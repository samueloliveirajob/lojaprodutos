package br.com.loja.view.endpoint.venda;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.loja.domain.venda.MeioPagamento;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MeioPagamentoDTO {

    @JsonProperty("code")
    private Long codigo;
    @JsonProperty("text")
    private String descricao;
    @JsonProperty("installments_value")
    private Double valorParcela;
    @JsonProperty("installments_quantity")
    private Integer quantidadeParcelas;
    @JsonProperty("credit_card")
    private CartaoCreditoDTO cartao;

    public MeioPagamentoDTO() {
    }

    public MeioPagamentoDTO(MeioPagamento meioPagamento) {
        this.codigo = meioPagamento.codigo();
        this.descricao = meioPagamento.descricao();
        this.valorParcela = meioPagamento.valorParcela();
        this.quantidadeParcelas = meioPagamento.quantidadeParcelas();
        if (meioPagamento.cartao() != null) {
            this.cartao = new CartaoCreditoDTO(meioPagamento.cartao());
        }
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValorParcela() {
        return valorParcela;
    }

    public Integer getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public CartaoCreditoDTO getCartao() {
        return cartao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
