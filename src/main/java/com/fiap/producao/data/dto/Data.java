package com.fiap.producao.data.dto;

import com.fiap.producao.domain.models.ProdutoModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Data {
    String orderStatus;
    String dataPedido;
    List<ProdutoModel> produtos;
    String id;
}
