package com.baldurtech.idCard;

import java.sql.Date;
import javax.persistence.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class IdCardRepository {
    @PersistenceContext
    EntityManager entityManager;
    
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public IdCard save(IdCard idCard) {
        entityManager.persist(idCard);
        return idCard;
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