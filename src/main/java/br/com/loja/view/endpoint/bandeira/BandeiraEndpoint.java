package br.com.loja.view.endpoint.bandeira;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.domain.bandeira.service.BandeiraService;
import br.com.loja.infrastructure.repository.cdto.bandeira.entity.BandeiraEntity;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("protegido")
public class BandeiraEndpoint {

    @Autowired
    private BandeiraService service;

    @RequestMapping(value = "/bandeiras", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity getPaymentMethod() throws ParseException {
        List<BandeiraEntity> bandeiras = service.findAll();
        Map<String, Object> json = new HashMap<>();
        json.put("data", bandeiras);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(json);
    }

    @RequestMapping(value = "/bandeiras/reset", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity reset() throws ParseException {

        service.delete();

        Map<String, Object> json = new HashMap<String, Object>();
        json.put("data", "Cache removido");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(json);
    }
}
