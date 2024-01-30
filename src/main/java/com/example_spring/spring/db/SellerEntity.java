package com.example_spring.spring.db;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "seller", schema = "simpleshop", catalog = "")
public class SellerEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idSeller", nullable = false)
    private int idSeller;
    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;


    public int getidSeller() {
        return idSeller;
    }

    public void setidSeller(int idSeller) {
        this.idSeller = idSeller;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellerEntity that = (SellerEntity) o;
        return idSeller == that.idSeller && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSeller, name);
    }


}
