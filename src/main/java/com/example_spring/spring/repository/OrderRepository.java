package com.example_spring.spring.repository;


import com.example_spring.spring.db.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<OrdersEntity, Integer> {
}
