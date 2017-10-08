package br.com.loja.infrastructure.repository.trng.loja.entity;

import br.com.loja.domain.loja.*;

public class LojaEntity implements Loja {

    private DocumentoEntity documento;
    private String email;
    private String razaoSocial;
    private SubcategoriaEntity subcategoria;
    private String nomeFantasia;
    private String site;
    private String identificacaoFaturaCartao;
    private TelefoneEntity telefone;
    private EnderecoEntity endereco;

    public void setDocumento(DocumentoEntity documento) {
        this.documento = documento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public void setSubcategoria(SubcategoriaEntity subcategoria) {
        this.subcategoria = subcategoria;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setIdentificacaoFaturaCartao(String identificacaoFaturaCartao) {
        this.identificacaoFaturaCartao = identificacaoFaturaCartao;
    }

    public void setTelefone(TelefoneEntity telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }

    @Override
    public Documento documento() {
        return this.documento;
    }

    @Override
    public String email() {
        return this.email;
    }

    @Override
    public String razaoSocial() {
        return this.razaoSocial;
    }

    @Override
    public Subcategoria subcategoria() {
        return this.subcategoria;
    }

    @Override
    public String nomeFantasia() {
        return this.nomeFantasia;
    }

    @Override
    public String site() {
        return this.site;
    }

    @Override
    public String identificacaoFaturaCartao() {
        return this.identificacaoFaturaCartao;
    }

    @Override
    public Telefone telefone() {
        return this.telefone;
    }

    @Override
    public Endereco endereco() {
        return this.endereco;
    }
}
