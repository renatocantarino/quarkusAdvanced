package com.cantarino.ifood.marketplace.resources;



import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cantarino.ifood.marketplace.dto.PratoDto;
import com.cantarino.ifood.marketplace.entities.Prato;

import io.smallrye.mutiny.Multi;
import io.vertx.mutiny.pgclient.PgPool;

@Path("/pratos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PratosResource {

    @Inject
    PgPool  pgPool;

    @GET
    public Multi<PratoDto> buscarPratos()
    {
        return Prato.findAll(pgPool);
    }






}