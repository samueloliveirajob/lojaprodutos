package br.com.loja.view.endpoint.loja;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.loja.domain.loja.Loja;

public class LojaDTO {

    @JsonProperty("document")
    private DocumentoDTO documento;
    @JsonProperty("e-mail")
    private String email;
    @JsonProperty("razao-social")
    private String razaoSocial;
    @JsonProperty("subcategoria")
    private SubcategoriaDTO subcategoria;
    @JsonProperty("nome-fantasia")
    private String nomeFantasia;
    @JsonProperty("site")
    private String site;
    @JsonProperty("identificacao-fatura-cartao")
    private String identificacaoFaturaCartao;
    @JsonProperty("phone")
    private TelefoneDTO telefone;
    @JsonProperty("address")
    private EnderecoDTO endereco;

    public LojaDTO(Loja loja) {
        this.documento = new DocumentoDTO(loja.documento());
        this.email = loja.email();
        this.razaoSocial = loja.razaoSocial();
        this.subcategoria = new SubcategoriaDTO(loja.subcategoria());
        this.nomeFantasia = loja.nomeFantasia();
        this.site = loja.site();
        this.identificacaoFaturaCartao = loja.identificacaoFaturaCartao();
        this.telefone = new TelefoneDTO(loja.telefone());
        this.endereco = new EnderecoDTO(loja.endereco());
    }

    public DocumentoDTO getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public SubcategoriaDTO getSubcategoria() {
        return subcategoria;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getSite() {
        return site;
    }

    public String getIdentificacaoFaturaCartao() {
        return identificacaoFaturaCartao;
    }

    public TelefoneDTO getTelefone() {
        return telefone;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }
}
