package br.com.loja.view.endpoint.venda;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.loja.domain.venda.Status;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatusDTO {

    @JsonProperty("code")
    private String codigo;
    @JsonProperty("text")
    private String descricao;

    public StatusDTO() {
    }

    public StatusDTO(Status status) {
        this.codigo = status.codigo();
        this.descricao = status.descricao();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
