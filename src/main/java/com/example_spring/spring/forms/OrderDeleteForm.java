package com.example_spring.spring.forms;

import com.example_spring.spring.db.OrdersEntity;

public class OrderDeleteForm {
    private OrdersEntity ordersEntity;

    public OrdersEntity getOrdersEntity() {
        return ordersEntity;
    }

    public void setOrdersEntity(OrdersEntity ordersEntity) {
        this.ordersEntity = ordersEntity;
    }

    public OrderDeleteForm(OrdersEntity ordersEntity) {
        this.ordersEntity = ordersEntity;
    }

    public OrderDeleteForm() {
    }
}
