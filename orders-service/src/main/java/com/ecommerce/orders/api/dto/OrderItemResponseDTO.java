package com.ecommerce.orders.api.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemResponseDTO {

    private String productId;
    private Integer quantity;
    private BigDecimal price;

}
