package com.cantarino.ifood.cadastro.infra.base;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class ValidDTOValidator    implements ConstraintValidator<ValidDTO, DTO> {


    @Override
    public void initialize(ValidDTO constraintAnnotation) {
    }


	@Override
	public boolean isValid(DTO value, ConstraintValidatorContext context) {

       return value.isValid(context);
  	}

}