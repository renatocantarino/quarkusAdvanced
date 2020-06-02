package com.cantarino.ifood.marketplace.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cantarino.ifood.marketplace.dto.PratoDto;
import com.cantarino.ifood.marketplace.entities.Prato;

import io.smallrye.mutiny.Multi;

@Path("/restaurantes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestauranteResource {

    @Inject
    io.vertx.mutiny.pgclient.PgPool pgPool;

    @GET
    @Path("idRestaurante/pratos")
    public Multi<PratoDto> buscarPratos(@PathParam("idRestaurante") Long idRestaurante)
    {

        return Prato.findAll(pgPool,idRestaurante);

    }






}