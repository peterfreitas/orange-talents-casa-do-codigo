package br.com.zupacademy.peter.casadocodigo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidaEstadoValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidaEstado {
    String message() default "País exige estado!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String field();
    String joinField();
}