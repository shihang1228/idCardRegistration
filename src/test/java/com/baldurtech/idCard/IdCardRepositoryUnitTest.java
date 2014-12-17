package com.baldurtech.idCard;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;
import javax.persistence.*;

public class IdCardRepositoryUnitTest {
    IdCard idCard;
    DateFormat format;
    
    @Mock
    EntityManager entityManager;
    
    @InjectMocks
    IdCardRepository idCardRepository;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        idCardRepository.setEntityManager(entityManager);
        
        idCard = new IdCard();
        
        idCard.setName("zhangsan");
        idCard.setGender("female");
        idCard.setFolk("han");
        idCard.setAgency("shanxi");
        idCard.setBirthday(Date.valueOf("2007-01-12"));
        idCard.setAddress("taiyuan");
        idCard.setCode("140000000000000000");
        
    }
    
    @Test
    public void 调用idCardRepository的save方法进行保存() {
        idCardRepository.save(idCard);
        verify(entityManager).persist(idCard);
    }
}