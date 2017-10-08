package integration;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.junit.Test;

import br.com.loja.view.endpoint.envio.dto.SmsDTO;
import integration.shared.IntegrationServer;


public class EnvioEndPointIT extends IntegrationServer {

    @Test
    public void servico_geracao_url_return_not_null() {
        given().get("http://127.0.0.1:" + jettyPort + "/street-api/url/10/Samuel/6322/21797")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("urlCompra", notNullValue());
    }
    
    
    @Test
    public void servico_envio_url_por_sms() {
    	
    	SmsDTO smsDTO = new SmsDTO();
    	smsDTO.setIdentificacao("8");
    	smsDTO.setCelular("11987882638,111111111");
    	smsDTO.setUrlCompra("https://localhost:8085/street-api/cadastro-street/8");
    	List<String> celularesErro = new ArrayList<String>();
    	List<String> celularesSucesso = new ArrayList<String>();
		smsDTO.setCelularesErro(celularesErro);
    	smsDTO.setCelularesSucesso(celularesSucesso);
    	
    	
    	Map<String, Object>  jsonAsMap = new HashMap<>();
    	jsonAsMap.put("identificacao", "8");
    	jsonAsMap.put("celular", "11987882638,111111111");
    	jsonAsMap.put("urlCompra", "https://localhost:8085/street-api/cadastro-street/8");

    	given()
    	.contentType("application/json")
    	.body(jsonAsMap)
    	.when()
    	.post("http://127.0.0.1:" + jettyPort + "/street-api/sendSMS")
    	.then()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .and()
        .body("celularesErro",   equalTo(Arrays.asList("111111111")),
        	 "celularesSucesso", equalTo(Arrays.asList("11987882638")));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


}
