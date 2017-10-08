package br.com.loja.domain.venda;

import java.util.Arrays;

public enum CanalOrigem {

    SUB("S", "WEB"),
    WALLET("W", "WEB"),
    M1("M1", "Nova API"),
    MPOS("MPOS", "Físico");

    private String code;
    private String description;

    CanalOrigem(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String code() {
        return code;
    }

    public String description() {
        return description;
    }

    public static CanalOrigem find(final String code) {
        return Arrays.stream(values())
                .filter(value -> value.code().equals(code))
                .findFirst()
                .orElse(null);
    }
}
