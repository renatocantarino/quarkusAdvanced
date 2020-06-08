package com.cantarino.ifood.pedido.models;

import java.util.List;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "pedidos" , database = "pedido")
public class Pedido extends PanacheMongoEntity {


    public String cliente;

    public List<Prato> pratos;

    public String entregador;

    public Localizacao localizacaoEntregador;

    public Restaurante restaurante;





}