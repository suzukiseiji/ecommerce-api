package com.ecommerce.orders.api.dto;

import lombok.Data;

@Data
public class CreateOrderItemRequestDTO {

    private String productId;
    private Integer quantity;

}
