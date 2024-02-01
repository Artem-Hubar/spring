package com.example_spring.spring.repository;


import com.example_spring.spring.db.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository  extends JpaRepository<OrdersEntity, Integer> {
}
