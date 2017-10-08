package br.com.loja.view.endpoint.login;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.infrastructure.utils.MethodLoggerBuilder;
import br.com.loja.view.endpoint.login.Person;

import javax.naming.NamingException;
import java.text.ParseException;
import java.util.Map;

/**
 * Created by STELO\renato.5a on 9/19/17.
 */
@RestController
@RequestMapping("portal-api")
public class LoginEndPoint {

    private static final Logger LOGGER = LogManager.getLogger();

    @RequestMapping(value = "/login", produces = {"application/json; charset=utf-8"})
    public ResponseEntity login(@RequestHeader Map<String, String> headers) throws ParseException, NamingException {
        MethodLoggerBuilder loggerBuilder = MethodLoggerBuilder
                .instance()
                .withClass(this.getClass().getSimpleName())
                .withMethod("login");

        Person person = PersonBuilder.aPerson()
                .withCnpj(headers.getOrDefault("STELO_CNPJ", ""))
                .withCpf(headers.getOrDefault("STELO_CPF", ""))
                .withEmail(headers.getOrDefault("STELO_EMAIL", ""))
                .withId(headers.getOrDefault("STELO_ID", ""))
                .withName(headers.getOrDefault("STELO_NAME", ""))
                .withProfiles(headers.getOrDefault("STELO_PROFILES", ""))
                .withRelationshipId(headers.getOrDefault("STELO_RELATIONSHIP_ID", ""))
                .build();

        LOGGER.info(loggerBuilder.withReturn(person).log());
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(person);
    }
}
