package br.com.loja.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.loja.service.EnvioService;
import br.com.loja.view.endpoint.envio.dto.EmailDTO;
import br.com.loja.view.endpoint.envio.dto.EnvioDTO;
import br.com.loja.view.endpoint.envio.dto.SmsDTO;

@Controller
public class EnvioController {
		
		 private static final Logger LOGGER = LogManager.getLogger();
		
		 @Autowired
		 private EnvioService envioService;
		 
		 public String getUrl(EnvioDTO requestEnvioDTO) {
			 try { 
				 return envioService.getUrl(requestEnvioDTO);
			 }catch(Exception e){
				 LOGGER.error("Error :" + e.getMessage());
		         return null;
		      }
		 }
		 
		 
		 public EnvioDTO findByCodeUrl(String codeUrl) {
			 try {
				 return envioService.findControleEnvioByCodeUrl(codeUrl);
			 }catch(Exception e){
				 LOGGER.error("Error :" + e.getMessage());
		         return null;
		      }
		 }
		
		public SmsDTO envioMultiSMS(SmsDTO smsDTO){
			return envioService.sendEnvioSms(smsDTO);
		}

		public EmailDTO sendEmailCadastro(EmailDTO emailDTO) {
			return envioService.sendEmailCad(emailDTO);
		}

}

