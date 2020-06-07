package com.cantarino.ifood.marketplace.messagings;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import com.cantarino.ifood.marketplace.entities.Restaurante;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import io.vertx.mutiny.pgclient.PgPool;

@ApplicationScoped
public class RestauranteAdd {


    @Inject
    private PgPool pgPool;

    @Incoming("restaurantes")
    public  void receive(String json) {

        Jsonb create = JsonbBuilder.create();
        Restaurante restaurante = create.fromJson(json, Restaurante.class);

        restaurante.persist(pgPool);
    }
}