package br.com.loja.view.endpoint.venda;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.loja.domain.venda.CartaoCredito;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartaoCreditoDTO {

    @JsonProperty("brand_code")
    private String codigoBandeira;
    @JsonProperty("brand_text")
    private String descricaoBandeira;
    @JsonProperty("number")
    private String numeroCartao;

    public CartaoCreditoDTO() {
    }

    public CartaoCreditoDTO(CartaoCredito cartaoCredito) {
        if (cartaoCredito != null) {
            this.codigoBandeira = cartaoCredito.codigoBandeira();
            this.descricaoBandeira = cartaoCredito.descricaoBandeira();
            this.numeroCartao = cartaoCredito.numeroCartao();
        }
    }

    public String getCodigoBandeira() {
        return codigoBandeira;
    }

    public String getDescricaoBandeira() {
        return descricaoBandeira;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setDescricaoBandeira(String descricaoBandeira) {
        this.descricaoBandeira = descricaoBandeira;
    }
}
