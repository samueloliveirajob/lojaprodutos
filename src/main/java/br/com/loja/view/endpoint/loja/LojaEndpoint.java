package br.com.loja.view.endpoint.loja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.loja.domain.ferramentas.seguranca.ChaveSegurancaNotFound;
import br.com.loja.domain.loja.Loja;
import br.com.loja.domain.loja.LojaNotFound;
import br.com.loja.domain.loja.service.LojaService;
import br.com.loja.view.endpoint.ErrorDTO;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("street-api")
public class LojaEndpoint {

    @Autowired
    LojaService service;

    @RequestMapping(value = "/store", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity getStore(@RequestHeader("STELO_ID") Long idStelo) throws ParseException {

        return this.parseToResponse(service.findBy(idStelo), HttpStatus.OK);
    }

    @ExceptionHandler(ChaveSegurancaNotFound.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDTO lojaNotFoundHandler(LojaNotFound ex, HttpServletResponse response) {
        return new ErrorDTO("loja_not_found", "Registro nao encontrado");
    }

    private ResponseEntity parseToResponse(Loja loja, HttpStatus status) {

        Map<String, Object> json = new HashMap<String, Object>();
        json.put("data", new LojaDTO(loja));
        return ResponseEntity
                .status(status)
                .body(json);
    }
}
