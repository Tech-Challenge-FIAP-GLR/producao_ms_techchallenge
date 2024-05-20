package com.fiap.producao.data.controllers;

import com.fiap.producao.data.dto.OrderStatusDTO;
import com.fiap.producao.domain.service.impl.AtualizaPedidoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/food_techchallenge/pedidos")
public class PedidoController {

    @Autowired
    AtualizaPedidoServiceImpl atualizaPedidoService;

    @Operation(
            summary = "Atualiza Status Pedidos",
            description = "Altera o status do pedido para o status seguinte.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @PutMapping("/{pedidoId}")
    public ResponseEntity<String> atualizaPedido(@PathVariable String pedidoId, @RequestBody OrderStatusDTO orderStatus){
        atualizaPedidoService.atualizaStatusPedido(pedidoId, orderStatus);
        return ResponseEntity.ok("Pedido atualizado.");
    }
}
