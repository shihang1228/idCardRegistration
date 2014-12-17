package com.baldurtech.idCard;

import org.springframework.stereotype.Repository;

@Repository
public class IdCardRepository {
    public IdCard save(IdCard idCard) {
        
        System.out.println(idCard.getName());
        System.out.println(idCard.getGender());
        System.out.println(idCard.getFolk());
        System.out.println(idCard.getAddress());
        System.out.println(idCard.getAgency());
        System.out.println(idCard.getBirthday());
        System.out.println(idCard.getCode());
        
        return idCard;
    }
}