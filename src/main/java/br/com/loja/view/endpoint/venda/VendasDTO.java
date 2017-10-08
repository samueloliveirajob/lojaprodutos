package br.com.loja.view.endpoint.venda;

import java.util.List;

public class VendasDTO {

    private List<VendaDTO> data;
    private Long amount;

    public VendasDTO() {
    }

    public List<VendaDTO> getData() {
        return data;
    }

    public void setData(List<VendaDTO> data) {
        this.data = data;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}