package com.example_spring.spring.repository;

import com.example_spring.spring.db.AuthGrantedAuthority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthGrantedAuthorityRepository extends JpaRepository<AuthGrantedAuthority, Long> {
}
