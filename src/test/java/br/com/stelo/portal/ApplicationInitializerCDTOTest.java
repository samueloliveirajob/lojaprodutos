package br.com.stelo.portal;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import br.com.loja.boot.environment.ApplicationInitializerCDTO;

@Configuration
@Profile("test")
@PropertySource("classpath:application-test.properties")
public class ApplicationInitializerCDTOTest extends ApplicationInitializerCDTO {

    public ApplicationInitializerCDTOTest() throws Exception {
    }
}
