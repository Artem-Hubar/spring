package com.example_spring.spring.repository;


import com.example_spring.spring.db.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<SellerEntity, Integer> {
}
