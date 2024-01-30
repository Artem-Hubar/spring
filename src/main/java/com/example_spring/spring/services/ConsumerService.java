package com.example_spring.spring.services;
import com.example_spring.spring.db.ConsumerEntity;
import com.example_spring.spring.repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ConsumerService {
    @Autowired
    private ConsumerRepository consumerRepository;

    public void save(ConsumerEntity consumer){
        consumerRepository.save(consumer);
    }

    public ConsumerEntity getConsumerById(int id){
        return consumerRepository.findById(id).orElse(null);
    }
}
