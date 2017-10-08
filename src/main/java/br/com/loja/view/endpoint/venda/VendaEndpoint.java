package br.com.loja.view.endpoint.venda;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import br.com.loja.domain.venda.VendaFilters;
import br.com.loja.domain.venda.VendaNotFound;
import br.com.loja.domain.venda.controller.VendaController;
import br.com.loja.infrastructure.utils.MethodLoggerBuilder;
import br.com.loja.view.endpoint.BindErrorDTO;
import br.com.loja.view.endpoint.BindErrorDTOBuilder;
import br.com.loja.view.endpoint.ErrorDTO;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("street-api")
public class VendaEndpoint {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private VendaController controller;

    @RequestMapping(
            value = "*//**",
            method = RequestMethod.OPTIONS
    )
    public ResponseEntity handle() {
        return new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity getOrder(@RequestHeader("STELO_ID") Long idStelo, @PathVariable(value = "id") Long id) throws ParseException {
        VendaDTO venda = controller.getOne(idStelo, id);
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("data", venda);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(json);
    }

    @CrossOrigin
    @RequestMapping(value = "/orders", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity<VendasDTO> getOrders(@RequestHeader("STELO_ID") Long idStelo, @Valid @ModelAttribute VendaFilters filters) throws ParseException {
        MethodLoggerBuilder logger = MethodLoggerBuilder.instance()
                .withClass(this.getClass().getSimpleName())
                .withMethod("getOrders")
                .withParams(idStelo, filters);

        VendasDTO orders = controller.getAll(idStelo, filters);
        ResponseEntity<VendasDTO> response = ResponseEntity
                .status(HttpStatus.OK)
                .body(orders);
        LOGGER.info(logger.log());
        return response;
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
