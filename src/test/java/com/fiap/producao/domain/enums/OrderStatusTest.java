package com.fiap.producao.domain.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderStatusTest {

    @Test
    void testGetCode() {
        assertEquals(1, OrderStatus.RECEIVED.getCode());
        assertEquals(2, OrderStatus.IN_PREPARATION.getCode());
        assertEquals(3, OrderStatus.READY.getCode());
        assertEquals(4, OrderStatus.COMPLETED.getCode());
    }

    @Test
    void testValueOf() {
        assertEquals(OrderStatus.RECEIVED, OrderStatus.valueOf(1));
        assertEquals(OrderStatus.IN_PREPARATION, OrderStatus.valueOf(2));
        assertEquals(OrderStatus.READY, OrderStatus.valueOf(3));
        assertEquals(OrderStatus.COMPLETED, OrderStatus.valueOf(4));
    }

    @Test
    void testValueOfInvalidCode() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            OrderStatus.valueOf(5);
        });
        assertEquals("Invalid order status code", exception.getMessage());
    }
}
