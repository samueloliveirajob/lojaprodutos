package br.com.loja.infrastructure.repository.trng.venda.entity;

import java.time.LocalDateTime;
import java.util.List;

import br.com.loja.domain.venda.CartaoCredito;
import br.com.loja.domain.venda.Venda;

public class VendaEntity implements Venda {

    private Long indice;
    private Long codigoPedidoStelo;
    private String codigoPedidoLoja;
    private String idTransacao;
    private String doc;
    private LocalDateTime dataCriacao;
    private Double desconto;
    private Double subtotal;
    private Double total;
    private List<ItemEntity> itens;
    private MeioPagamentoEntity pagamento;
    private EntregaEntity entrega;
    private StatusEntity status;
    private ClienteEntity cliente;
    private CanalVendaEntity canal;
    private CartaoCreditoEntity cartaoCredito;

    @Override
    public Long codigoPedidoStelo() {
        return this.codigoPedidoStelo;
    }

    @Override
    public String codigoPedidoLoja() {
        return this.codigoPedidoLoja;
    }

    @Override
    public String idTransacao() {
        return this.idTransacao;
    }

    @Override
    public LocalDateTime dataCriacao() {
        return this.dataCriacao;
    }

    @Override
    public String doc() {
        return this.doc;
    }

    @Override
    public Double desconto() {
        return this.desconto;
    }

    @Override
    public Double subtotal() {
        return this.subtotal;
    }

    @Override
    public Double total() {
        return this.total;
    }

    @Override
    public List itens() {
        return this.itens;
    }

    @Override
    public MeioPagamentoEntity pagamento() {
        return this.pagamento;
    }

    @Override
    public EntregaEntity entrega() {
        return this.entrega;
    }

    @Override
    public StatusEntity status() {
        return this.status;
    }

    @Override
    public ClienteEntity cliente() {
        return this.cliente;
    }

    @Override
    public CanalVendaEntity canal() {
        return this.canal;
    }

    @Override
    public CartaoCredito cartaoCredito() {
        return this.cartaoCredito;
    }

    public void setCodigoPedidoStelo(Long codigoPedidoStelo) {
        this.codigoPedidoStelo = codigoPedidoStelo;
    }

    public void setCodigoPedidoLoja(String codigoPedidoLoja) {
        this.codigoPedidoLoja = codigoPedidoLoja;
    }

    public void setIdTransacao(String idTransacao) {
        this.idTransacao = idTransacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setItens(List<ItemEntity> itens) {
        this.itens = itens;
    }

    public void setPagamento(MeioPagamentoEntity pagamento) {
        this.pagamento = pagamento;
    }

    public void setEntrega(EntregaEntity entrega) {
        this.entrega = entrega;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public void setCanal(CanalVendaEntity canal) {
        this.canal = canal;
    }

    public void setCartaoCredito(CartaoCreditoEntity cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public Long getIndice() {
        return indice;
    }

    public void setIndice(Long indice) {
        this.indice = indice;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }
}
