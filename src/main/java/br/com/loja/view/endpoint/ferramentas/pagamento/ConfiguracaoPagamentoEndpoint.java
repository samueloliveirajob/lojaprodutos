package br.com.loja.view.endpoint.ferramentas.pagamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.loja.domain.ferramentas.pagamento.ConfiguracaoPagamento;
import br.com.loja.domain.ferramentas.pagamento.service.ConfiguracaoPagamentoNotFound;
import br.com.loja.domain.ferramentas.pagamento.service.ConfiguracaoPagamentoService;
import br.com.loja.domain.ferramentas.seguranca.ChaveSegurancaNotFound;
import br.com.loja.view.endpoint.ErrorDTO;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("street-api")
public class ConfiguracaoPagamentoEndpoint {

    @Autowired
    ConfiguracaoPagamentoService service;

    @RequestMapping(value = "/payment-config", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity getConfiguracaoPagamento(@RequestHeader("STELO_ID") Long idStelo) throws ParseException {
        return this.parseToResponse(service.findBy(idStelo), HttpStatus.OK);
    }

    @ExceptionHandler(ChaveSegurancaNotFound.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDTO configuracaoPagamentoNotFoundHandler(ConfiguracaoPagamentoNotFound ex, HttpServletResponse response) {
        return new ErrorDTO("configuracao_pagamento_not_found", "Registro nao encontrado");
    }

    private ResponseEntity parseToResponse(ConfiguracaoPagamento pagamento, HttpStatus status) {

        Map<String, Object> json = new HashMap<String, Object>();
        json.put("data", new ConfiguracaoPagamentoDTO(pagamento));
        return ResponseEntity
                .status(status)
                .body(json);
    }
}
