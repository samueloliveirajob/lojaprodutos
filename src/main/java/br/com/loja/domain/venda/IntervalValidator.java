package br.com.loja.domain.venda;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by STELO\renato.5a on 9/13/17.
 */
public class IntervalValidator implements ConstraintValidator<DateInterval, VendaFilters> {
    private DateInterval constraint;

    public void initialize(DateInterval constraint) {
        this.constraint = constraint;
    }

    public boolean isValid(VendaFilters filters, ConstraintValidatorContext context) {
        if(filters.hasDateInterval()){
            return filters.getDateTo().after(filters.getDateFrom());
        }if(!filters.hasDateTo() && !filters.hasDateFrom()){
            return true;
        }else {
            return false;
        }
    }
}
