package com.cantarino.ifood.marketplace.entities;

import java.math.BigDecimal;
import java.util.stream.StreamSupport;

import com.cantarino.ifood.marketplace.dto.PratoDto;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.RowSet;
import io.vertx.mutiny.sqlclient.Tuple;

public class Prato {

    public Long id;

    public String nome;

    public String descricao;

    public Restaurante restaurante;

    public BigDecimal preco;

    public static Multi<PratoDto> findAll(PgPool pgPool)
    {
        Uni<RowSet<Row>> preparedQuery = pgPool.preparedQuery("select * from prato");
        return unitToMulti(preparedQuery);
    }

    public static Multi<PratoDto> findAll(PgPool pgPool, Long idRestaurante)
    {
        Uni<RowSet<Row>> preparedQuery =
            pgPool.preparedQuery("select * from prato where prato.restaurante_id = $1 ORDER BY nome ASC",
                                  Tuple.of(idRestaurante));

            return unitToMulti(preparedQuery);
    }

    public static Uni<PratoDto> findById(PgPool client, Long id) {
        return client.preparedQuery("SELECT * FROM prato WHERE id = $1", Tuple.of(id))
                .map(RowSet::iterator)
                .map(iterator -> iterator.hasNext() ? PratoDto.from(iterator.next()) : null);
    }

    private static Multi<PratoDto> unitToMulti(Uni<RowSet<Row>> queryResult) {
        return queryResult.onItem()
                .produceMulti(set -> Multi.createFrom().items(() -> {
                    return StreamSupport.stream(set.spliterator(), false);
                })).onItem().apply(PratoDto::from);
    }

}