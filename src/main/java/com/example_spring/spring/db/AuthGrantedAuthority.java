package com.example_spring.spring.db;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
public class AuthGrantedAuthority implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public AuthUserDetails getAuthUserDetails() {
        return authUserDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthUserDetails(AuthUserDetails authUserDetails) {
        this.authUserDetails = authUserDetails;
    }

    private String authority;

    @ManyToOne
    @JoinColumn(name = "auth_user_detail_id")
    private AuthUserDetails authUserDetails;

    @Override
    public String getAuthority() {
        return authority;
    }

    //constructors
    //getters and setters

}
