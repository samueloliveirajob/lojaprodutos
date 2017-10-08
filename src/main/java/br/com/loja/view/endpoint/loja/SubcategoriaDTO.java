package br.com.loja.view.endpoint.loja;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.loja.domain.loja.Subcategoria;

public class SubcategoriaDTO {

    @JsonProperty("id")
    private int id;
    @JsonProperty("description")
    private String descricao;

    public SubcategoriaDTO(Subcategoria subcategoria) {
        this.id = subcategoria.id();
        this.descricao = subcategoria.descricao();
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}
