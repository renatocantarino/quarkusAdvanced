package com.cantarino.ifood.cadastro.dtos.restaurante;

import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.cantarino.ifood.cadastro.infra.base.DTO;
import com.cantarino.ifood.cadastro.infra.base.ValidDTO;
import com.cantarino.ifood.cadastro.models.Restaurante;

@ValidDTO
public class AddRestaurante implements DTO {

    @Pattern(regexp = "[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}\\/[0-9]{4}\\-[0-9]{2}")
    @NotEmpty
    public String Cnpj;

    @Size(min = 3 , max = 30)
    public String Nome;

    @NotEmpty
    public String proprietario;

    public LocalizacaoDTO localizacao;


    @Override
    public boolean isValid(ConstraintValidatorContext validatorContext)
    {
        validatorContext.disableDefaultConstraintViolation();
        if (Restaurante.find("cnpj", Cnpj).count() > 0) {
            validatorContext.buildConstraintViolationWithTemplate("CNPJ já cadastrado")
                    .addPropertyNode("cnpj")
                    .addConstraintViolation();
            return false;
        }
        return true;

    }



}