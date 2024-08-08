package com.fiap.producao.data.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "pedido")
public class PedidoDTO {
    Data data;
}
