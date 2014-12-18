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
       return entityManager.createNamedQuery(IdCard.GET_BY_ID, IdCard.class)
                     .setParameter("id", id)
                     .getSingleResult();
    }
}