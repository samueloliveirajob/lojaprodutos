package br.com.loja.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.loja.controller.SendSmsResponse;
import br.com.loja.controller.ZenviaResponse;
import br.com.loja.infrastructure.repository.cdto.envio.EnvioRepository;
import br.com.loja.infrastructure.repository.cdto.envio.entity.ControleEnvioEntity;
import br.com.loja.infrastructure.utils.DateUtil;
import br.com.loja.service.EnvioService;
import br.com.loja.service.MandrillService;
import br.com.loja.view.endpoint.envio.dto.EmailDTO;
import br.com.loja.view.endpoint.envio.dto.EnvioDTO;
import br.com.loja.view.endpoint.envio.dto.SmsDTO;

@Service
public class EnvioServiceImpl implements EnvioService {

    private static final Logger LOGGER = LogManager.getLogger();
    
	private static final String UrlCadastro = "https://localhost:8085/street-api/cadastro-street/";

	@Autowired
	private MandrillService mandrillService;

    @Autowired
    private EnvioRepository repository;

    @Override
    public Boolean save(ControleEnvioEntity entity) {
        LOGGER.info("save ControleEnvioEntity");
        return repository.save(entity);
    }
    
    @Override
    public ControleEnvioEntity saveURI(ControleEnvioEntity entity) {
        LOGGER.info("save ControleEnvioEntity");
        return repository.saveURI(entity);
    }

    @Override
	public EnvioDTO findControleEnvioByCodeUrl(String encode) {
    	  LOGGER.info("findControleEnvioByCodeUrl");
    	  return converEntitytEnvioDTO(repository.findControleEnvioByCodeUrl(encode));
	}

    
    
    public String getUrl(EnvioDTO requestEnvioDTO) {
		
    	ControleEnvioEntity entity = null;
    	
		 try { 
			 
			//TODO Caso ja exista retorna o ja criado.
			entity = repository.findControleEnvio(requestEnvioDTO);
			
			 if(null == entity 
					 || null == entity.getUrlCompra() 
					 || "".equals(entity.getUrlCompra())){
				 
				 requestEnvioDTO.setUrlCompra(UrlCadastro);
				 entity = repository.saveURI(convertEnvioDTOEntity(requestEnvioDTO));
				 
		         return entity.getUrlCompra();	
			 }else{
				return entity.getUrlCompra();
		     }
	         
		 }catch(Exception e){
			 LOGGER.error("Error :" + e.getMessage());
	         return UrlCadastro;
	      }
	}
    
    
    
    
    /**
	 * @param nome
	 * @param emailList
	 * @param UrlBankEncodeCadastro
	 * @return
	 */
	public EmailDTO sendEmailCad(EmailDTO emailDTO) {

		List<String> emailsSucesso = new ArrayList<String>();
		List<String> emailsErro = new ArrayList<String>();

		List<String> destinatarios = new ArrayList<>(Arrays.asList(emailDTO.getEmailList().split(";")));
		
		try {
		
			Map<String,String> variaveisBind = new HashMap<>(); 
			
			variaveisBind.put("apelidoComprador", emailDTO.getNome());
			variaveisBind.put("urlCadastro", emailDTO.getUrlCompra());
			
			List<MandrillResponseDTO> responseDTO = mandrillService.sendMailCadastro(destinatarios, variaveisBind);
			
			for (MandrillResponseDTO mandrillResponseDTO : responseDTO) {
				if ("sent".equalsIgnoreCase(mandrillResponseDTO.getStatus()) || "queued".equalsIgnoreCase(mandrillResponseDTO.getStatus())) {
					emailsSucesso.add(mandrillResponseDTO.getEmail());
				} else {
					emailsErro.add(mandrillResponseDTO.getEmail());
				}
			}
			
			emailDTO.setEmailsSucesso(emailsSucesso);
			emailDTO.setEmailsErro(emailsErro);
			
			for (String emailSucesso : emailsSucesso) {
				repository.saveURIEnviado(emailDTO.getIdentificacao(), null, emailSucesso, Boolean.TRUE);
			}			

			for (String emailErro : emailsErro) {
				repository.saveURIEnviado(emailDTO.getIdentificacao(), null, emailErro, Boolean.FALSE);
			}
			
		} catch (Exception e) {
			 LOGGER.error("Error ao enviar e-mail para: " + emailDTO.getEmailList() + ": " + e.getMessage());
		}
		return emailDTO;
	}
    
	@Override
	public ControleEnvioEntity convertEnvioDTOEntity(EnvioDTO envioDTO) {
		ControleEnvioEntity entity = new ControleEnvioEntity();
		entity.setNomeCompleto(envioDTO.getNome());
		entity.setNuAgencia(envioDTO.getNuAgencia());
		entity.setIdSolicitante(envioDTO.getIdSolicitante());
		entity.setUrlCompra(envioDTO.getUrlCompra());
		entity.setIdCanalOrigem(envioDTO.getCanalOrigem());
		entity.setUsrAlt("APP_CREDENCIAMENTO");
		entity.setUsrIncl("APP_CREDENCIAMENTO");
		entity.setDtAlteracao(new Date());
		entity.setDtInclusao(new Date());
		return entity;
	}
	
	
	@Override
	public EnvioDTO converEntitytEnvioDTO(ControleEnvioEntity envio) {
		EnvioDTO dto = new EnvioDTO();
		dto.setIdUri(envio.getIdUri());
		dto.setCanalOrigem(envio.getIdCanalOrigem());
		dto.setNuAgencia(envio.getNuAgencia());
		dto.setIdSolicitante(envio.getIdSolicitante());
		dto.setNome(envio.getNomeCompleto());
		dto.setUrlCompra(envio.getUrlCompra());
		return dto;
	}

	/**
	 * @param celularesCliente
	 * @param UrlEncode
	 * @return
	 */
	public SmsDTO sendEnvioSms(SmsDTO smsDTO) {
		int occurance = StringUtils.countOccurrencesOf(smsDTO.getCelular(), ",");
		String[] celulares = new String[occurance];
		celulares = smsDTO.getCelular().split(",");
		
		List<String> celularesErro = new ArrayList<String>();
		List<String> celularesSucesso = new ArrayList<String>();
		
		try {
				String msg = "Finalize a compra da sua maquininha Stelo: "+smsDTO.getUrlCompra();

				StringBuilder json = new StringBuilder();
				json.append("{");
				json.append("\"sendSmsMultiRequest\": {");
				json.append("\"aggregateId\": \"9362\",");
				json.append("\"sendSmsRequestList\": [ ");
				
				 for (int i = 0; i < celulares.length; i++) {
					 extractEnvio(celulares[i], msg, json);
					 if(i < (celulares.length -1 )){
							json.append(",");
						}
				}
				json.append("]");
				json.append("}");
				json.append("}");

				Client client = ClientBuilder.newClient();
				Entity payload = Entity.json(json.toString());
				
				Response response = client.target("https://api-rest.zenvia360.com.br/services/send-sms-multiple")
				  .request(MediaType.APPLICATION_JSON_TYPE)
				  .header("Authorization", "Basic aG9tb2xvZy5zdGVsbzozRExjc3pYYUM5=")
				  .header("Accept", "application/json")
				  .post(payload);
	
				
				if(HttpStatus.OK.value() == response.getStatus()){
					
					List<SendSmsResponse> smsResponses = response.readEntity(ZenviaResponse.class).getSendSmsMultiResponse().getSendSmsResponseList();
					
					for (int i = 0; i < smsResponses.size(); i++) {
						if(!"00".equals(smsResponses.get(i).getStatusCode())){
							celularesErro.add(celulares[i]);
							LOGGER.info("celular com ERRO:" + celulares[i]);
						}else{
							celularesSucesso.add(celulares[i]);
						}
					}
					
					smsDTO.setCelularesErro(celularesErro);
					smsDTO.setCelularesSucesso(celularesSucesso);
					
					for (String celErro : celularesErro) {
						repository.saveURIEnviado(smsDTO.getIdentificacao(), celErro, null, Boolean.FALSE);
					}
					
					for (String celSucesso : celularesSucesso) {
						repository.saveURIEnviado(smsDTO.getIdentificacao(), celSucesso, null, Boolean.TRUE);
					}
					
					return smsDTO;
				}else{
					LOGGER.info("Não Enviado");
					return smsDTO;
				}
				
		} catch (Exception e) {
			 LOGGER.error("Error :" + e.getMessage());
			 return smsDTO;
		}
	}
	

	/**
	 * @param msg
	 * @param json
	 */
	private void extractEnvio(String celularCliente, String msg, StringBuilder json) {
		String idEnvio = celularCliente + new Date().getTime();
		json.append(" { \"from\": \"" + "STELO" + "\",");
		json.append("\"to\": \"55" + celularCliente + "\",");
		json.append("\"schedule\": \""+DateUtil.stringFormatNowDateISO8691()+"\", ");
		json.append("\"msg\": \"" + msg + "\",");
		json.append("\"callbackOption\": \"NONE\",");
		json.append("\"id\": \""+idEnvio+"\"");
		json.append("}");
		LOGGER.info("Id da mensagem: "+idEnvio);
	}
	
	
	
}
