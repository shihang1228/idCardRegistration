package com.baldurtech.idCard;

import java.sql.Date;

public class CreateIdCard {

    IdCard idCard;
    
    public IdCard createValidIdCard() {
        idCard = new IdCard();
        
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