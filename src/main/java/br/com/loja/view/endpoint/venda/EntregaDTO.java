package br.com.loja.view.endpoint.venda;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.loja.domain.venda.Entrega;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EntregaDTO {

    @JsonProperty("cost")
    private Double valor;
    @JsonProperty("shipping_address")
    private EnderecoEntregaDTO endereco;

    public EntregaDTO() {
    }

    public EntregaDTO(Entrega entrega) {
        if (entrega != null) {
            this.valor = entrega.valor();
            this.endereco = new EnderecoEntregaDTO(entrega.endereco());
        }
    }

    public Double getValor() {
        return valor;
    }

    public EnderecoEntregaDTO getEndereco() {
        return endereco;
    }
}
