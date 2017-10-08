package br.com.loja.infrastructure.repository.trng.loja.entity;

import br.com.loja.domain.loja.Subcategoria;

public class SubcategoriaEntity implements Subcategoria {

    private int id;
    private String descricao;

    public void setId(int id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int id() {
        return this.id;
    }

    @Override
    public String descricao() {
        return this.descricao;
    }
}
