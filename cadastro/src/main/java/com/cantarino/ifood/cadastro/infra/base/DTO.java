package com.cantarino.ifood.cadastro.infra.base;

import javax.validation.ConstraintValidatorContext;

public interface DTO {

    default boolean isValid(ConstraintValidatorContext validatorContext)
    {
        return true;
    }

}