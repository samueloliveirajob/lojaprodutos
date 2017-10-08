package br.com.loja.view.endpoint;

/**
 * Created by STELO\renato.5a on 9/12/17.
 */
public final class BindErrorDTOBuilder {
    private String message;
    private String field;

    private BindErrorDTOBuilder() {
    }

    public static BindErrorDTOBuilder aBindErrorDTO() {
        return new BindErrorDTOBuilder();
    }

    public BindErrorDTOBuilder withMessage(String message) {
        this.message = message;
        return this;
    }

    public BindErrorDTOBuilder withField(String field) {
        this.field = field;
        return this;
    }

    public BindErrorDTO build() {
        BindErrorDTO bindErrorDTO = new BindErrorDTO(field, message);
        return bindErrorDTO;
    }
}
