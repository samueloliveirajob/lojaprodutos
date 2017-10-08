package br.com.loja.view.endpoint.venda;

import java.util.List;

/**
 * Created by STELO\renato.5a on 9/11/17.
 */
public final class VendasDTOBuilder {
    private List<VendaDTO> data;
    private Long amount;

    private VendasDTOBuilder() {
    }

    public static VendasDTOBuilder aVendasDTO() {
        return new VendasDTOBuilder();
    }

    public VendasDTOBuilder withData(List<VendaDTO> data) {
        this.data = data;
        return this;
    }

    public VendasDTOBuilder withAmount(Long amount) {
        this.amount = amount;
        return this;
    }

    public VendasDTO build() {
        VendasDTO vendasDTO = new VendasDTO();
        vendasDTO.setData(data);
        vendasDTO.setAmount(amount);
        return vendasDTO;
    }
}
