package br.com.loja.view.endpoint.venda.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.loja.domain.venda.Cliente;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteDTO {

    @JsonProperty("name")
    private String nome;
    @JsonProperty("document")
    private DocumentoDTO documento;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {
        this.nome = cliente.nome();
        this.documento = new DocumentoDTO(cliente.documento());
    }

    public String getNome() {
        return nome;
    }

    public DocumentoDTO getDocumento() {
        return documento;
    }
}
