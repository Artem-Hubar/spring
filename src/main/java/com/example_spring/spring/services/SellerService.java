package com.example_spring.spring.services;

import com.example_spring.spring.db.OrdersEntity;
import com.example_spring.spring.db.SellerEntity;
import com.example_spring.spring.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {
    @Autowired
    private SellerRepository SellerRepository;

    public void save(SellerEntity seller){
        SellerRepository.save(seller);
    }

    public SellerEntity getSellerById(Integer id){
        return SellerRepository.findById(id).orElse(null);
    }

    public List<SellerEntity> getAllSellors(){
        return SellerRepository.findAll();
    }
}
