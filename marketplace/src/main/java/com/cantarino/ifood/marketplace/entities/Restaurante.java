package com.cantarino.ifood.marketplace.entities;

import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Tuple;

public class Restaurante {


        public Long id;
        public String nome;
        public Localizacao localizacao ;

        @Override
        public String toString()
        {
           return "Restaurante [ID=" + id + ", nome=" + nome + " , Localizacao=" + localizacao;
        }

	public void persist(PgPool pgPool) {

           pgPool.preparedQuery("INSERT INTO LOCALIZACAO (id , latitute , longitude)  values ($1, $2, $3)" ,
                        Tuple.of(localizacao.Id , localizacao.Latitude , localizacao.Longitude)).await().indefinitely();


           pgPool.preparedQuery("INSERT INTO RESTAURANTE (id , nome, localizacao_id)  values ($1, $2, $3)" ,
                        Tuple.of(id , nome , localizacao.Id)).await().indefinitely();
        }
}