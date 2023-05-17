package org.example.service;


import org.example.model.Visitor;
import org.example.repository.CafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CafeService {
    @Autowired
    private final CafeRepository cafeRepository;

    public CafeService(CafeRepository cafeRepository) {
        this.cafeRepository = cafeRepository;
    }

    @Transactional
    public Visitor createFeedback(String name, String email, String rate, String feedback){
        if ((name == null || feedback == null || email == null) && rate == null) {
            return null;
        } else {
            Visitor visitor = new Visitor();
            visitor.setName(name);
            visitor.setEmail(email);
            visitor.setRate(rate);
            visitor.setFeedback(feedback);
            return cafeRepository.save(visitor);
        }
    }
}
