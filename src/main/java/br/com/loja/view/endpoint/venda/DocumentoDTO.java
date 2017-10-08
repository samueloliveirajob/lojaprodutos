package br.com.loja.view.endpoint.venda;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.loja.domain.loja.Documento;

public class DocumentoDTO {

    @JsonProperty("type")
    private String tipo;
    @JsonProperty("value")
    private String valor;

    public DocumentoDTO() {
    }

    public DocumentoDTO(Documento documento) {
        this.tipo = documento.tipo();
        this.valor = documento.valor();
    }

    public String getTipo() {
        return tipo;
    }

    public String getValor() {
        return valor;
    }
}
