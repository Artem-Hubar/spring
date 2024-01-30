package com.example_spring.spring.db;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "orders", schema = "simpleshop", catalog = "")
public class OrdersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idOrder", nullable = false)
    private int idOrder;
    @Basic
    @Column(name = "title", nullable = false, length = 45)
    private String title;
    @Basic
    @Column(name = "amount", nullable = false)
    private int amount;

    @ManyToOne
    @JoinColumn(name = "Seller_idSeller", referencedColumnName = "idSeller", nullable = false)
    private SellerEntity SellerBySelleridSeller;

    @ManyToOne
    @JoinColumn(name = "Consumer_idConsumer", referencedColumnName = "idConsumer", nullable = false)
    private ConsumerEntity consumerByConsumerIdConsumer;

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersEntity that = (OrdersEntity) o;
        return idOrder == that.idOrder && amount == that.amount && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrder, title, amount);
    }

    public SellerEntity getSellerBySelleridSeller() {
        return SellerBySelleridSeller;
    }

    public void setSellerBySelleridSeller(SellerEntity SellerBySelleridSeller) {
        this.SellerBySelleridSeller = SellerBySelleridSeller;
    }

    public ConsumerEntity getConsumerByConsumerIdConsumer() {
        return consumerByConsumerIdConsumer;
    }

    public void setConsumerByConsumerIdConsumer(ConsumerEntity consumerByConsumerIdConsumer) {
        this.consumerByConsumerIdConsumer = consumerByConsumerIdConsumer;
    }
}
