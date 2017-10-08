package br.com.loja.infrastructure.repository.trng.venda.entity;

import br.com.loja.domain.venda.Cliente;
import br.com.loja.infrastructure.repository.trng.loja.entity.DocumentoEntity;

public class ClienteEntity implements Cliente {

    private String nome;
    private DocumentoEntity documento;

    @Override
    public String nome() {
        return this.nome;
    }

    @Override
    public DocumentoEntity documento() {
        return this.documento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDocumento(DocumentoEntity documento) {
        this.documento = documento;
    }
}
