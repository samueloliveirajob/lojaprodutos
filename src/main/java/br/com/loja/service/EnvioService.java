package br.com.loja.service;

import br.com.loja.infrastructure.repository.cdto.envio.entity.ControleEnvioEntity;
import br.com.loja.view.endpoint.envio.dto.EmailDTO;
import br.com.loja.view.endpoint.envio.dto.EnvioDTO;
import br.com.loja.view.endpoint.envio.dto.SmsDTO;

public interface EnvioService {

	Boolean save(ControleEnvioEntity entity);

	ControleEnvioEntity saveURI(ControleEnvioEntity entity);
	
	String getUrl(EnvioDTO requestEnvioDTO);
	
	EnvioDTO findControleEnvioByCodeUrl(String encode);

	EmailDTO sendEmailCad(EmailDTO emailDTO) ;
	
	SmsDTO sendEnvioSms(SmsDTO smsDTO);
	
	ControleEnvioEntity convertEnvioDTOEntity(EnvioDTO envioDTO);

	EnvioDTO converEntitytEnvioDTO(ControleEnvioEntity envio);


}
