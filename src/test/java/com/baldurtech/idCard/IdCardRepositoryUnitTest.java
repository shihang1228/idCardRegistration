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
import static org.mockito.Mockito.when;
import javax.persistence.*;

public class IdCardRepositoryUnitTest extends CreateIdCard {
    IdCard idCard;
    IdCard idCard_has_saved;
    DateFormat format;
    Long ID = 132L;
    
    @Mock
    TypedQuery typedQuery;
    
    @Mock
    EntityManager entityManager;
    
    @InjectMocks
    IdCardRepository idCardRepository;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        idCardRepository.setEntityManager(entityManager);
        
        idCard = createValidIdCard();
        
        idCard_has_saved = createValidIdCard();
        idCard_has_saved.setId(ID);
    }
    
    @Test
    public void 调用idCardRepository的save方法进行保存() {
        assertEquals(idCard, idCardRepository.save(idCard));
        verify(entityManager).persist(idCard);
    }
    
    @Test
    public void 调用idCardRepository中的getById方法来获取idCard() {
        when(entityManager.createNamedQuery(IdCard.GET_BY_ID, IdCard.class)).thenReturn(typedQuery);
        when(typedQuery.setParameter("id", ID)).thenReturn(typedQuery);
        when(typedQuery.getSingleResult()).thenReturn(idCard_has_saved);
        
        assertEquals(idCard_has_saved, idCardRepository.getById(ID));
    }
}