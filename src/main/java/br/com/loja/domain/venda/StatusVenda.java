package br.com.loja.domain.venda;

import java.util.Arrays;

public enum StatusVenda {

    I("i", "Pedido Iniciado"),
    AP("ap", "Aguardando Pagamento"),
    N("n", "Negado Instituição Financeira"),
    AT("at", "Autorizado Instituição Financeira"),
    ER("er", "Em Análise de Risco"),
    NR("nr", "Negado Risco"),
    AR("ar", "Autorizado"),
    A("a", "Aprovado"),
    CO("co", "Aprovado"),
    C("c", "Cancelado"),
    CP("cp", "Cancelado Parcial"),
    E("e", "Cancelado"),
    EC("ec", "Em Cancelamento");

    private String code;
    private String description;

    StatusVenda(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String code() {
        return code;
    }

    public String description() {
        return description;
    }

    public static StatusVenda find(final String code) {
        return Arrays.stream(values())
                .filter(value -> value.code().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }
}
