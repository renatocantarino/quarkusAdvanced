package com.cantarino.ifood.marketplace.entities;

public class Restaurante {


        public Long id;
        public String nome;
        public Localizacao localizacao ;

        @Override
        public String toString()
        {
           return "Restaurante [ID=" + id + ", nome=" + nome + " , Localizacao=" + localizacao;
        }
}