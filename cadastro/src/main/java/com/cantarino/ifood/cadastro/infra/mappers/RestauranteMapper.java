package com.cantarino.ifood.cadastro.infra.mappers;

import com.cantarino.ifood.cadastro.dtos.restaurante.*;
import com.cantarino.ifood.cadastro.models.Restaurante;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "cdi")
public interface RestauranteMapper {

    @Mapping(target = "dataCriacao", dateFormat = "dd/MM/yyyy HH:mm:ss")
    public RestauranteDTO toRestauranteDTO(Restaurante entity);

    public Restaurante  toRestaurante(AddRestaurante dto);

    public void toRestaurante(EditRestaurante dto , @MappingTarget Restaurante entity);


}