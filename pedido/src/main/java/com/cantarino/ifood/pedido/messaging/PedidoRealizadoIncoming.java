package com.cantarino.ifood.pedido.messaging;



import com.cantarino.ifood.pedido.dtos.PedidoRealizadoDto;
import com.cantarino.ifood.pedido.dtos.PratoPedidoDto;
import com.cantarino.ifood.pedido.models.Pedido;
import com.cantarino.ifood.pedido.models.Prato;
import com.cantarino.ifood.pedido.models.Restaurante;

import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.bind.JsonbBuilder;

import org.bson.types.Decimal128;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class PedidoRealizadoIncoming {



    @Incoming("pedidos")
    public void lerPedidos(PedidoRealizadoDto dto) {
        System.out.println("-----------------");
        System.out.println(dto);

       // Pedido p = new Pedido();
      //  p.cliente = dto.cliente;
       // p.pratos = new ArrayList<>();
      ///  dto.pratos.forEach(prato -> p.pratos.add(from(prato)));
      //  Restaurante restaurante = new Restaurante();
      //  restaurante.nome = dto.restaurante.nome;
     //   p.restaurante = restaurante;
     //   String json = JsonbBuilder.create().toJson(dto);
        //elastic.index("pedidos", json);
     //   p.persist();

    }

    private Prato from(PratoPedidoDto prato) {
        Prato p = new Prato();
        p.descricao = prato.descricao;
        p.nome = prato.nome;
        p.preco = new Decimal128(prato.preco);
        return p;
    }






}