package com.ecommerce.orders.api.controller;

import com.ecommerce.orders.api.dto.CreateOrderRequestDTO;
import com.ecommerce.orders.api.dto.OrderResponseDTO;
import com.ecommerce.orders.domain.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponseDTO create(@RequestBody CreateOrderRequestDTO dto) {
        return orderService.createOrder(dto);
    }
}
