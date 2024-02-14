package com.example_spring.spring.repository;

import com.example_spring.spring.db.AuthUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUserDetailsRepository extends JpaRepository<AuthUserDetails, Long> {
    Optional<AuthUserDetails> findByUsername(String username);
    Optional<AuthUserDetails> findByPassword(String password);
}
