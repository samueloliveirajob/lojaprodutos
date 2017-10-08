package br.com.loja.service;

import java.util.List;
import java.util.Map;

import br.com.loja.service.impl.MandrillResponseDTO;

public interface MandrillService {

	List<MandrillResponseDTO> sendMailCadastro(List<String> toList, Map<String, String> tplVars) ;
	
	List<MandrillResponseDTO> sendMail(List<String> toList, String templateName, Map<String, String> tplVars) ;
	
}
