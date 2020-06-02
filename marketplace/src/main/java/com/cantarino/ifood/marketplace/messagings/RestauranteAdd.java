package com.cantarino.ifood.marketplace.messagings;

import javax.enterprise.context.ApplicationScoped;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import com.cantarino.ifood.marketplace.entities.Restaurante;

import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class RestauranteAdd {


    @Incoming("restaurantes")
    public  void receive(String json) {

        Jsonb create = JsonbBuilder.create();
        Restaurante restaurante = create.fromJson(json, Restaurante.class);

        System.out.println(restaurante);


    }



}