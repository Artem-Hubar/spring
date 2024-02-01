package com.example_spring.spring.services;

import com.example_spring.spring.db.OrdersEntity;
import com.example_spring.spring.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void save(OrdersEntity ordersEntity){
        orderRepository.save(ordersEntity);
    }

    public OrdersEntity getOrderById(Integer id){
        return orderRepository.findById(id).orElse(null);
    }

    public List<OrdersEntity> getAllOrders(){
        return orderRepository.findAll();
    }


    public void deleteOrderByEntity(OrdersEntity entity){
        orderRepository.delete(entity);
    }
}
