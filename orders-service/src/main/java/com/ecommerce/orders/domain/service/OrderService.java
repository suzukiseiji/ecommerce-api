package com.ecommerce.orders.domain.service;

import com.ecommerce.orders.api.dto.CreateOrderRequestDTO;
import com.ecommerce.orders.api.dto.OrderResponseDTO;
import com.ecommerce.orders.api.mapper.OrderMapper;
import com.ecommerce.orders.domain.Order;
import com.ecommerce.orders.domain.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    // Injeção de Dependências via construtor
    // O Spring automaticamente fornecerá as instâncias de OrderRepository and OrderMapper
    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    /**
     * Orquestra a criação de um novo pedido.
     * @param dto O objeto de transferência de dados com as informações do pedido.
     * @return O DTO de resposta com as informações do pedido criado.
     */
    public OrderResponseDTO createOrder(CreateOrderRequestDTO dto) {
        // 1. Converte o DTO de requisição para uma Entidade
        Order order = orderMapper.toEntity(dto);

        // 2. Salva a entidade no banco de dados
        Order savedOrder = orderRepository.save(order);

        // 3. Converte a entidade salva para um DTO de resposta e o retorna
        return orderMapper.toDto(savedOrder);
    }
}
