package com.example_spring.spring.repository;

import com.example_spring.spring.db.ConsumerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumerRepository extends JpaRepository<ConsumerEntity, Integer> {
}
