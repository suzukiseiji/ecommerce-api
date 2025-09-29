package com.ecommerce.orders.api.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderResponseDTO {

    private String orderId;
    private String userId;
    private String status;
    private BigDecimal total;
    private List<OrderItemResponseDTO> items;

}
