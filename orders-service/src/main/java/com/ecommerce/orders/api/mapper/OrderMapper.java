package com.ecommerce.orders.api.mapper;

import com.ecommerce.orders.api.dto.CreateOrderRequestDTO;
import com.ecommerce.orders.api.dto.OrderItemResponseDTO;
import com.ecommerce.orders.api.dto.OrderResponseDTO;
import com.ecommerce.orders.domain.Order;
import com.ecommerce.orders.domain.OrderItem;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public Order toEntity(CreateOrderRequestDTO dto) {
        Order order = new Order();
        order.setId(UUID.randomUUID().toString());
        order.setUserId(dto.getUserId());
        order.setStatus("PENDING");

        List<OrderItem> items = dto.getItems().stream().map(itemDTO -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(itemDTO.getProductId());
            orderItem.setQuantity(itemDTO.getQuantity());

            // TODO: Buscar o preço real do produto em um serviço de produtos.
            // Por enquanto, usaremos um valor fixo para desenvolvimento.
            BigDecimal price = BigDecimal.TEN; // Ex: R$10.00
            orderItem.setPrice(price);

            // Associa o item ao pedido (essencial para o relacionamento JPA)
            orderItem.setOrder(order);
            return orderItem;
        }).collect(Collectors.toList());

        order.setItems(items);

        // Calcula o total do pedido
        BigDecimal total = items.stream()
                .map(item -> item.getPrice().multiply(new BigDecimal(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        order.setTotal(total);

        return order;
    }

    public OrderResponseDTO toDto(Order order) {
        OrderResponseDTO dto = new OrderResponseDTO();
        dto.setOrderId(order.getId());
        dto.setUserId(order.getUserId());
        dto.setStatus(order.getStatus());
        dto.setTotal(order.getTotal());

        List<OrderItemResponseDTO> itemDtos = order.getItems().stream().map(itemEntity -> {
            OrderItemResponseDTO itemDto = new OrderItemResponseDTO();
            itemDto.setProductId(itemEntity.getProductId());
            itemDto.setQuantity(itemEntity.getQuantity());
            itemDto.setPrice(itemEntity.getPrice());
            return itemDto;
        }).collect(Collectors.toList());

        dto.setItems(itemDtos);

        return dto;
    }
}
