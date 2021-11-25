package br.com.zupacademy.peter.casadocodigo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EstadoUnicoValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EstadoUnico {
    String message() default "Estado já cadastrado para esse país!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}