package br.com.loja.domain.venda;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by STELO\renato.5a on 9/13/17.
 */


@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IntervalValidator.class)
public @interface DateInterval {
    String message() default "{br.com.stelo.portal.date.validator.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
