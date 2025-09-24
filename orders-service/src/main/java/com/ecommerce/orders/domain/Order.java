package com.ecommerce.orders.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Represents an Order in the e-commerce system.
 * This is a JPA entity mapped to the 'orders' table.
 */
@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Order {

    @Id
    private String id;

    private String userId;

    private String status;

    private BigDecimal total;

}
