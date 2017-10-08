package br.com.loja.view.endpoint.venda.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.loja.domain.venda.CanalVenda;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CanalVendaDTO {

    @JsonProperty("code")
    private String codigo;
    @JsonProperty("text")
    private String descricao;

    public CanalVendaDTO() {
    }

    public CanalVendaDTO(CanalVenda canalVenda) {
        this.codigo = canalVenda.codigo();
        this.descricao = canalVenda.descricao();
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
