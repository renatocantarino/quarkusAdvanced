package com.cantarino.ifood.cadastro.resources;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cantarino.ifood.cadastro.models.Prato;
import com.cantarino.ifood.cadastro.models.Restaurante;

import org.hibernate.validator.constraints.pl.PESEL;

@Path("/api/pratos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes (MediaType.APPLICATION_JSON)
public class PratoResource {

    @GET
    @Path("{idRestaurante}/pratos")
    public List<Prato> buscar(@PathParam("idRestaurante") Long idRestaurante)
    {
        Optional<Restaurante> _restaurante = Restaurante.findByIdOptional(idRestaurante);

        if(!_restaurante.isPresent())
           throw new NotFoundException();


        return Prato.list("restaurante", _restaurante.get());

    }


    @POST
    @Transactional
    @Path("{idRestaurante}/pratos")
    public Prato adicionar(@PathParam("idRestaurante") Long idRestaurante , Prato dto)
    {
        Optional<Restaurante> _restaurante = Restaurante.findByIdOptional(idRestaurante);

        if(!_restaurante.isPresent())
           throw new NotFoundException();


        dto.persist();
        return dto;
    }


    @PUT
    @Transactional
    @Path("{idRestaurante}/pratos/{idPrato}")
    public Prato update(@PathParam("idRestaurante") Long idRestaurante ,
                                    @PathParam("idPrato")  Long idPrato, Prato dto)
    {
        Optional<Restaurante> _restaurante = Restaurante.findByIdOptional(idRestaurante);

        if(!_restaurante.isPresent())
            throw new NotFoundException();

        Optional<Prato> _prato = Prato.findByIdOptional(idRestaurante);
        if(!_prato.isPresent())
            throw new NotFoundException();



        Prato prato = _prato.get();
        prato.Nome = dto.Nome;
        prato.descricao = dto.descricao;
        prato.preco = dto.preco;

        prato.persist();
        return prato;
    }


    @DELETE
    @Transactional
    @Path("{idRestaurante}/pratos/{idPrato}")
    public void delete(@PathParam("idRestaurante") Long idRestaurante ,
                                    @PathParam("idPrato")  Long idPrato, Prato dto)
    {
        Optional<Restaurante> _restaurante = Restaurante.findByIdOptional(idRestaurante);

        if(!_restaurante.isPresent())
            throw new NotFoundException();

        Optional<Prato> _prato = Prato.findByIdOptional(idRestaurante);

        _prato.ifPresentOrElse(Prato::delete , () -> { throw new NotFoundException();  });
     }
}