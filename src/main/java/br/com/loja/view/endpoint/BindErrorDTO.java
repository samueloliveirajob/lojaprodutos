package br.com.loja.view.endpoint;

public class BindErrorDTO {

    private String message;
    private String field;

    public BindErrorDTO(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getField() {
        return field;
    }
}
