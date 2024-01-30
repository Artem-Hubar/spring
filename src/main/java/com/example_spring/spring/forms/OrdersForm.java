package com.example_spring.spring.forms;

import com.example_spring.spring.db.ConsumerEntity;
import com.example_spring.spring.db.SellerEntity;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;

import java.util.List;

public class OrdersForm {
    private List<ConsumerEntity> consumerEntityList;

    private List<SellerEntity> sellerEntityList;

    public SellerEntity getSelectedSeller() {
        return selectedSeller;
    }

    public void setSelectedSeller(SellerEntity selectedSeller) {
        this.selectedSeller = selectedSeller;
    }

    private  SellerEntity selectedSeller;

    public ConsumerEntity getSelectedConsumer() {
        return selectedConsumer;
    }

    public void setSelectedConsumer(ConsumerEntity selectedConsumer) {
        this.selectedConsumer = selectedConsumer;
    }

    private  ConsumerEntity selectedConsumer;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    private String title;

    private int amount;

    public OrdersForm(List<ConsumerEntity> consumerEntityList, List<SellerEntity> sellerEntityList) {
        this.consumerEntityList = consumerEntityList;
        this.sellerEntityList = sellerEntityList;
    }

    public OrdersForm() {
    }

    public List<ConsumerEntity> getConsumerEntityList() {
        return consumerEntityList;
    }

    public void setConsumerEntityList(List<ConsumerEntity> consumerEntityList) {
        this.consumerEntityList = consumerEntityList;
    }

    public List<SellerEntity> getSellerEntityList() {
        return sellerEntityList;
    }

    public void setSellerEntityList(List<SellerEntity> sellerEntityList) {
        this.sellerEntityList = sellerEntityList;
    }
}
