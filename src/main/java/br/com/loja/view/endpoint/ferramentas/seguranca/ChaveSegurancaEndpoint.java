package br.com.loja.view.endpoint.ferramentas.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.loja.domain.ferramentas.seguranca.ChaveSeguranca;
import br.com.loja.domain.ferramentas.seguranca.ChaveSegurancaNotFound;
import br.com.loja.domain.ferramentas.seguranca.service.ChaveSegurancaService;
import br.com.loja.domain.venda.VendaNotFound;
import br.com.loja.view.endpoint.ErrorDTO;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("street-api")
public class ChaveSegurancaEndpoint {

    @Autowired
    private ChaveSegurancaService service;

    @RequestMapping(value = "/security-key", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity getChaveSeguranca(@RequestHeader("STELO_ID") Long idStelo) throws ParseException {
        return this.parseToResponse(service.findBy(idStelo), HttpStatus.OK);
    }

    @ExceptionHandler(ChaveSegurancaNotFound.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDTO chaveSegurancaNotFoundHandler(VendaNotFound ex, HttpServletResponse response) {
        return new ErrorDTO("venda_not_found", "Registro nao encontrado");
    }

    private ResponseEntity parseToResponse(ChaveSeguranca chaveSeguranca, HttpStatus status) {

        Map<String, Object> json = new HashMap<String, Object>();
        json.put("data", new ChaveSegurancaDTO(chaveSeguranca));
        return ResponseEntity
                .status(status)
                .body(json);
    }

    public void setService(ChaveSegurancaService service) {
        this.service = service;
    }
}
