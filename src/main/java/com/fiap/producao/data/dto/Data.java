package com.fiap.producao.data.dto;

import com.fiap.producao.domain.models.ProdutoModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Data {
    private User user;
    private String orderStatus;
    private String dataPedido;
    private List<ProdutoModel> produtos;
    private String id;
    private double total;

}
