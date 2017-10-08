package br.com.stelo.portal;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import br.com.loja.boot.environment.ApplicationInitializerTRNG;

@Configuration
@Profile("test")
@PropertySource("classpath:application-test.properties")
public class ApplicationInitializerTRNGTest extends ApplicationInitializerTRNG {

    public ApplicationInitializerTRNGTest() throws Exception {
    }
}
