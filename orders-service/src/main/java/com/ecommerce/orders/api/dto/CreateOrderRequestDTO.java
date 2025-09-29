package com.ecommerce.orders.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequestDTO {

    private String userId;
    private List<CreateOrderItemRequestDTO> items;

}
