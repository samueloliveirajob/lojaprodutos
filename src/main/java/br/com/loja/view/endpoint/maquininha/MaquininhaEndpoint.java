package br.com.loja.view.endpoint.maquininha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.loja.domain.ferramentas.seguranca.ChaveSegurancaNotFound;
import br.com.loja.domain.maquininha.Maquininha;
import br.com.loja.domain.maquininha.MaquininhaNotFound;
import br.com.loja.domain.maquininha.service.MaquininhaService;
import br.com.loja.view.endpoint.ErrorDTO;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("street-api")
public class MaquininhaEndpoint {

    @Autowired
    MaquininhaService service;

    @RequestMapping(value = "/machine", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity getStore(@RequestHeader("STELO_ID") Long idStelo) throws ParseException {

        return this.parseToResponse(service.findBy(idStelo), HttpStatus.OK);
    }

    @ExceptionHandler(ChaveSegurancaNotFound.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDTO lojaNotFoundHandler(MaquininhaNotFound ex, HttpServletResponse response) {
        return new ErrorDTO("machine_not_found", "Registro nao encontrado");
    }

    private ResponseEntity parseToResponse(List<Maquininha> maquininhas, HttpStatus status) {

        List<MaquininhaDTO> dtos = new ArrayList<>();
        for (Maquininha maquininha : maquininhas) {
            dtos.add(new MaquininhaDTO(maquininha));
        }

        Map<String, Object> json = new HashMap<String, Object>();
        json.put("data", dtos);
        return ResponseEntity
                .status(status)
                .body(json);
    }
}
