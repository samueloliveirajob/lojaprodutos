package br.com.loja.view.endpoint;

public class ErrorDTO {

    private String message;
    private String code;

    public ErrorDTO(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
