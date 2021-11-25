package br.com.zupacademy.peter.casadocodigo.validator;

import org.springframework.beans.BeanWrapperImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class ValidaEstadoValidator implements ConstraintValidator<ValidaEstado, Object> {

    @PersistenceContext
    private EntityManager entityManager;

    private String field;
    private String joinField;

    @Override
    public void initialize(ValidaEstado param) {
        this.field = param.field();
        this.joinField = param.joinField();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Object fieldValue = new BeanWrapperImpl(o)
                .getPropertyValue(field);
        Object fieldJoinValue = new BeanWrapperImpl(o)
                .getPropertyValue(joinField);


        if (fieldJoinValue != null) {
            Query query = entityManager.createQuery("select 1 from Estado e join e.pais p where p.id =:value and e.id =:value2");
            query.setParameter("value", fieldValue);
            query.setParameter("value2", fieldJoinValue);
            Optional<?> resultList = query.getResultList().stream().findFirst();

            boolean isValid = resultList.isPresent();

            if (!isValid) {
                constraintValidatorContext.disableDefaultConstraintViolation();
                constraintValidatorContext.buildConstraintViolationWithTemplate("Id inválido!")
                        .addPropertyNode("estadoId")
                        .addConstraintViolation();
            }

            return resultList.isPresent();
        } else {
            Query query = entityManager.createQuery("select 1 from Estado e join e.pais p where p.id =:value");
            query.setParameter("value", fieldValue);
            Optional<?> resultList = query.getResultList().stream().findFirst();

            return resultList.isEmpty();
        }

    }
}
