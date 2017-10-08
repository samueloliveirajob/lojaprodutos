package br.com.loja.view.endpoint.venda;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import br.com.loja.domain.venda.Venda;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VendaDTO {

    @JsonProperty("stelo_order_id")
    private Long codigoPedidoStelo;
    @JsonProperty("store_order_id")
    private String codigoPedidoLoja;
    @JsonProperty("transaction_id")
    private String idTransacao;
    @JsonProperty("doc")
    private String doc;
    @JsonProperty("created_at")
    private LocalDateTime dataCriacao;
    @JsonProperty("discount")
    private Double desconto;
    @JsonProperty("subtotal")
    private Double subtotal;
    @JsonProperty("total")
    private Double total;
    @JsonProperty("itens")
    private List<ItemDTO> itens;
    @JsonProperty("payment_method")
    private MeioPagamentoDTO pagamento;
    @JsonProperty("shipping")
    private EntregaDTO entrega;
    @JsonProperty("status")
    private StatusDTO status;
    @JsonProperty("customer")
    private ClienteDTO cliente;
    @JsonProperty("channel")
    private CanalVendaDTO canal;

    public VendaDTO() {
    }

    public VendaDTO(Venda venda) {
        this.codigoPedidoStelo = venda.codigoPedidoStelo();
        this.codigoPedidoLoja = venda.codigoPedidoLoja();
        this.idTransacao = venda.idTransacao();
        this.dataCriacao = venda.dataCriacao();
        this.desconto = venda.desconto();
        this.subtotal = venda.subtotal();
        this.total = venda.total();
        if (venda.itens() != null) {
            this.itens = venda.itens()
                    .stream()
                    .map(item -> new ItemDTO(item))
                    .collect(Collectors.toList());
        }
        this.pagamento = new MeioPagamentoDTO(venda.pagamento());
        if (venda.entrega() != null) {
            this.entrega = new EntregaDTO(venda.entrega());
        }
        this.status = new StatusDTO(venda.status());
        this.cliente = new ClienteDTO(venda.cliente());
        this.canal = new CanalVendaDTO(venda.canal());
        this.doc = venda.doc();
    }

    public Long getCodigoPedidoStelo() {
        return codigoPedidoStelo;
    }

    public String getCodigoPedidoLoja() {
        return codigoPedidoLoja;
    }

    public String getIdTransacao() {
        return idTransacao != null ? idTransacao.toString() : "-";
    }

    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public Double getDesconto() {
        return desconto;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public Double getTotal() {
        return total;
    }

    public List<ItemDTO> getItens() {
        return itens;
    }

    public MeioPagamentoDTO getPagamento() {
        return pagamento;
    }

    public EntregaDTO getEntrega() {
        return entrega;
    }

    public StatusDTO getStatus() {
        return status;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public CanalVendaDTO getCanal() {
        return canal;
    }

    public String getDoc() {
        return doc;
    }
}
