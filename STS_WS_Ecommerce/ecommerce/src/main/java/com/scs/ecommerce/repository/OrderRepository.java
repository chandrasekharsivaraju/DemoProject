package com.scs.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scs.ecommerce.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
