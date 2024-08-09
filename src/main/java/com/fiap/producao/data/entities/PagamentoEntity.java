package com.fiap.producao.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "pagamentos")
public class PagamentoEntity {
    @Id
    @Column(name = "pedido_id")
    private String pedidoId;


    @Column(name = "data_gerado")
    private String dataPagamentoGerado;

    @Column(name = "data_confirmado")
    private String dataPagamentoConfirmado;

    @Column(name = "order_status")
    private String orderStatus;


}
