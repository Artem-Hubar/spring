package com.example_spring.spring.repository;


import com.example_spring.spring.db.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<SellerEntity, Integer> {
}
