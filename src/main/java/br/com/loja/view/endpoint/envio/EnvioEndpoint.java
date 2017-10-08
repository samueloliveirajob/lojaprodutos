package br.com.loja.view.endpoint.envio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.controller.EnvioController;
import br.com.loja.domain.venda.VendaNotFound;
import br.com.loja.infrastructure.utils.MethodLoggerBuilder;
import br.com.loja.view.endpoint.BindErrorDTO;
import br.com.loja.view.endpoint.BindErrorDTOBuilder;
import br.com.loja.view.endpoint.ErrorDTO;
import br.com.loja.view.endpoint.envio.dto.EmailDTO;
import br.com.loja.view.endpoint.envio.dto.EnvioDTO;
import br.com.loja.view.endpoint.envio.dto.SmsDTO;
import br.com.loja.view.endpoint.venda.VendasDTO;

@RestController
@RequestMapping("street-api")
public class EnvioEndpoint {

    private static final Logger LOGGER = LogManager.getLogger();
    
    @Autowired
    private EnvioController envioController;

    @CrossOrigin
    @RequestMapping(value = "/url/{canalOrigem}/{nome}/{idAgencia}/{idSolicitante}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getUrlBankCadastro(@PathVariable(value = "canalOrigem") Integer canalOrigem, 
    		@PathVariable(value = "nome") String nome,
    		@PathVariable(value = "idAgencia") String idAgencia, 
    		@PathVariable(value = "idSolicitante") String idSolicitante){
    	
    	EnvioDTO envioDTO = new EnvioDTO(canalOrigem, nome, idAgencia, idSolicitante);
    	
    	String url = envioController.getUrl(envioDTO);
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("urlCompra", url);
        
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(json);
    }
    
    @CrossOrigin
    @RequestMapping(value = "/url/{canalOrigem}/{nome}/{idSolicitante}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getUrlCadastro(@PathVariable(value = "canalOrigem") Integer canalOrigem, 
    		@PathVariable(value = "nome") String nome, 
    		@PathVariable(value = "idSolicitante") String idSolicitante){
    	
    	EnvioDTO envioDTO = new EnvioDTO(canalOrigem, nome, idSolicitante);
    	String url = envioController.getUrl(envioDTO);
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("urlCompra", url);
        
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(json);
    }
    
    @CrossOrigin
    @RequestMapping(value = "/findByCodeUrl/{codeUrl}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<EnvioDTO> findByUrl(@PathVariable(value = "codeUrl") String codeUrl){
    	 ResponseEntity<EnvioDTO> response = ResponseEntity
                 .status(HttpStatus.OK)
                 .body(envioController.findByCodeUrl(codeUrl));
	   	return response;
    }
    
    @CrossOrigin
    @RequestMapping(value = "/sendSMS", method = RequestMethod.POST, produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<SmsDTO> sendSMS( @RequestBody SmsDTO smsDTO){
    	 ResponseEntity<SmsDTO> response = ResponseEntity
                 .status(HttpStatus.OK)
                 .body(envioController.envioMultiSMS(smsDTO));
	   	return response;
    }
    
    @CrossOrigin
    @RequestMapping(value = "/sendEmailCadastro", method = RequestMethod.POST, produces =  MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> sendEmailCadastro(@RequestBody EmailDTO emailDTO){
    	EmailDTO responseEmailDTO = envioController.sendEmailCadastro(emailDTO);
    	Map<String, Object> json = new HashMap<String, Object>();
		json.put("emailResponse", responseEmailDTO);
	 	return ResponseEntity.status(HttpStatus.OK).body(json);    		
    }    

    @ExceptionHandler(BindException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<BindErrorDTO> filterErrorHandler(BindException ex, HttpServletResponse response) {
        List<BindErrorDTO> erros = ex.getAllErrors().stream().map(objectError -> {
            if(objectError instanceof FieldError) {
                FieldError fieldError = FieldError.class.cast(objectError);
                return BindErrorDTOBuilder
                        .aBindErrorDTO()
                        .withField(fieldError.getField())
                        .withMessage(fieldError.getDefaultMessage())
                        .build();
            }else{

                return BindErrorDTOBuilder
                        .aBindErrorDTO()
                        .withField(objectError.getCode())
                        .withMessage(objectError.getDefaultMessage())
                        .build();
            }

        }).collect(Collectors.toList());
        LOGGER.warn(MethodLoggerBuilder.instance()
                .withClass(this.getClass().getSimpleName())
                .withMethod("filterErrorHandler")
                .withParams(erros)
                .log());
        return erros;
    }


    @ExceptionHandler(VendaNotFound.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDTO vendaNotFoundHandler(VendaNotFound ex, HttpServletResponse response) {
        LOGGER.warn(MethodLoggerBuilder.instance()
                .withClass(this.getClass().getSimpleName())
                .withMethod("vendaNotFoundHandler")
                .withParams(ex.getLocalizedMessage())
                .log());
        return new ErrorDTO("venda_not_found", "Registros nao encontrados");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDTO internalError(Exception ex, HttpServletResponse response) {
        LOGGER.warn(MethodLoggerBuilder.instance()
                .withClass(this.getClass().getSimpleName())
                .withMethod("internalError")
                .withParams(ex.getLocalizedMessage())
                .log());
        return new ErrorDTO("Internal Error", "erro");
    }
}
