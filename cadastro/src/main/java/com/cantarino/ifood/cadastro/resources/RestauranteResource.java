package com.cantarino.ifood.cadastro.resources;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cantarino.ifood.cadastro.models.Restaurante;

@Path("/api/restaurantes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes (MediaType.APPLICATION_JSON)
public class RestauranteResource {

    @GET
    public List<Restaurante> buscar() {
        return Restaurante.listAll();
    }


    @POST
    @Transactional
    public Restaurante adicionar(Restaurante dto) {

        dto.persist();
        return dto;
    }

    @PUT
    @Path("{ id }")
    @Transactional
    public Restaurante update(@PathParam("id")Long id, Restaurante dto) {

        dto.persist();
        return dto;
    }
}

