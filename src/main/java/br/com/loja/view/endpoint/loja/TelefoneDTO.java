package br.com.loja.view.endpoint.loja;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.loja.domain.loja.Telefone;

public class TelefoneDTO {

    @JsonProperty("type")
    private String tipo;
    @JsonProperty("value")
    private String valor;

    public TelefoneDTO(Telefone telefone) {
        this.tipo = telefone.tipo();
        this.valor = telefone.valor();
    }

    public String getTipo() {
        return tipo;
    }

    public String getValor() {
        return valor;
    }
}
