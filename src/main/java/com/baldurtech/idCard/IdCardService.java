package com.baldurtech.idCard;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class IdCardService {
    IdCardRepository idCardRepository;
    
    @Autowired
    public IdCardService(IdCardRepository idCardRepository) {
        this.idCardRepository = idCardRepository;
    }
    
    public IdCard save(IdCard idCard) {
        return idCardRepository.save(idCard);
    } 
    
    public IdCard getById(Long id) {
        return idCardRepository.getById(id);
    } 
}