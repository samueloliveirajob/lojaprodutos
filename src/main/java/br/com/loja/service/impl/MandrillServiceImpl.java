package br.com.loja.service.impl;

import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.loja.service.MandrillService;

@Service
public class MandrillServiceImpl implements MandrillService{

	private static final Logger LOGGER = LogManager.getLogger();
	
    @Value("${stelo.project.street.mandrill.url}")
    private String mandrillUrl;	
	
    @Value("${stelo.project.street.mandrill.key}")
    private String mandrillKey;
    
    @Value("${stelo.project.street.mandrill.template.cadastro}")
    private String mandrillTplCadastro;
	
    public List<MandrillResponseDTO> sendMailCadastro(List<String> toList, Map<String, String> tplVars) {
    	return this.sendMail(toList, this.mandrillTplCadastro, tplVars);    	
    }
    
	public List<MandrillResponseDTO> sendMail(List<String> toList, String templateName, Map<String, String> tplVars) {

		List<MandrillResponseDTO> responseList = null;
		
		JSONObject jsonRequest = this.getJsonRequest(toList, templateName, tplVars);
		
		Client client = ClientBuilder.newClient();
		Entity<String> payload = Entity.json(jsonRequest.toString());
		
		Response response = client.target(this.mandrillUrl)
		  .request(MediaType.APPLICATION_JSON_TYPE)
		  .header("Accept", "application/json")
		  .post(payload);
		
		if(HttpStatus.OK.value() == response.getStatus()){
			responseList = response.readEntity(new GenericType<List<MandrillResponseDTO>>() { });
		} else {
			LOGGER.error("Erro (HTTP Status: " + response.getStatus() + ") ao enviar e-mail para: " + String.join(",", toList));
		}
		
		return responseList;
	}
	
	private JSONObject getJsonRequest(List<String> toList, String templateName, Map<String, String> tplVars) {
		// To
		JSONArray jsonToArray = new JSONArray();
		for (String to : toList) {
			JSONObject jsonTo = new JSONObject();
			jsonTo.put("email", to);
			jsonToArray.put(jsonTo);
		}

		// Template Variables
		JSONArray jsonGlobalVarsArray = new JSONArray();
		for (Map.Entry<String, String> entry : tplVars.entrySet()) {
			JSONObject jsonVar = new JSONObject();
			jsonVar.put("name", entry.getKey());
			jsonVar.put("content", entry.getValue());
			jsonGlobalVarsArray.put(jsonVar);
		}
		
		// Message
		JSONObject jsonMessage = new JSONObject();
		jsonMessage.put("to", jsonToArray);
		jsonMessage.put("global_merge_vars", jsonGlobalVarsArray);
		
		
		// JSON Request Object
		JSONObject jsonRequest = new JSONObject();
		jsonRequest.put("key", "idUpo6XGxMzLyAXzmpqFUw");
		jsonRequest.put("template_name", templateName);
		jsonRequest.put("template_content", new JSONArray());
		jsonRequest.put("async", false);
		jsonRequest.put("message", jsonMessage);
		
		return jsonRequest;
	}
	
}
