package br.com.loja.domain.venda;

import java.time.LocalDateTime;
import java.util.List;

public interface Venda {

    Long codigoPedidoStelo();

    String codigoPedidoLoja();

    String idTransacao();

    String doc();

    LocalDateTime dataCriacao();

    Double desconto();

    Double subtotal();

    Double total();

    List<Item> itens();

    MeioPagamento pagamento();

    Entrega entrega();

    Status status();

    Cliente cliente();

    CanalVenda canal();

    CartaoCredito cartaoCredito();

}
