package com.cantarino.ifood.pedido.utils;

import com.cantarino.ifood.pedido.dtos.PedidoRealizadoDto;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;


public class PedidoDeserializer extends ObjectMapperDeserializer<PedidoRealizadoDto>  {

    public PedidoDeserializer()
    {
        super(PedidoRealizadoDto.class);
    }
}