package br.com.loja.view.endpoint.maquininha;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.controller.MaquinaController;

@RestController
@RequestMapping("street-api")
public class MaquinaCompraEndpoint {

    @Autowired
    public MaquinaController controller;

    @CrossOrigin
    @RequestMapping(value = "/maquina/{idStelo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getStoreEC(@PathVariable(value = "idStelo") String idStelo) throws ParseException {
    	List<MaquinaCompraDTO> dtos = controller.carregaMaqEC(idStelo);
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("data", dtos);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(json);
    }
    
    
    @RequestMapping(value = "/maquina", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity addStoreEC( @RequestBody MaquinaCompraDTO maquinaDTO) {
    	try {
    		if(controller.addStoreEC(maquinaDTO)){
	            Map<String, Object> json = new HashMap<String, Object>();
	            json.put("retorno", "criado!");
	            return ResponseEntity
	                    .status(HttpStatus.CREATED)
	                    .body(json);
    		}else{
    			Map<String, Object> json = new HashMap<String, Object>();
	            json.put("retorno", "Falha!");
	            return ResponseEntity
	                    .status(HttpStatus.BAD_REQUEST)
	                    .body(json);
    		}
		} catch (Exception e) {
			 Map<String, Object> json = new HashMap<String, Object>();
	            json.put("retorno", "Falha!");
	            return ResponseEntity
	                    .status(HttpStatus.BAD_REQUEST)
	                    .body(json);
		}
    	
    }
    
    
    @RequestMapping(value = "/maquinaa", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity addStoreEC( @RequestBody Teste teste) {
    	try {
            Map<String, Object> json = new HashMap<String, Object>();
            json.put("retorno", "criado!");
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(json);
		} catch (Exception e) {
			 Map<String, Object> json = new HashMap<String, Object>();
	            json.put("retorno", "Falha!");
	            return ResponseEntity
	                    .status(HttpStatus.BAD_REQUEST)
	                    .body(json);
		}
    	
    }


}
