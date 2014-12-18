package com.baldurtech.idCard;

import java.sql.Date;

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
        IdCard idCard = new IdCard();
        
        idCard.setName("zhangsan");
        idCard.setGender("female");
        idCard.setFolk("han");
        idCard.setAgency("shanxi");
        idCard.setBirthday(Date.valueOf("2007-01-12"));
        idCard.setAddress("taiyuan");
        idCard.setCode("140000000000000000");
        
        return idCard;
    }
}