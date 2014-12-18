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

public class IdCardServiceUnitTest extends CreateIdCard {
    IdCard idCard;
    IdCard idCard_has_saved;
    DateFormat format;
    Long ID = 13L;
    
    @Mock
    IdCardRepository idCardRepository;
    
    @InjectMocks
    IdCardService idCardService;
    
    @Before 
    public void setup() {
        MockitoAnnotations.initMocks(this);
        
        idCard = createValidIdCard();
        
        idCard_has_saved = createValidIdCard();
        idCard_has_saved.setId(ID);
    }
    
    @Test
    public void 调用save方法时应该返回idCard() {
        when(idCardRepository.save(idCard)).thenReturn(idCard);
        
        assertEquals(idCard, idCardService.save(idCard));
        verify(idCardRepository).save(idCard);
    }
    
    @Test
    public void 调用getById方法是应该调用repository的getById方法并返回idCard() {
        when(idCardRepository.getById(ID)).thenReturn(idCard_has_saved);
        
        assertEquals(idCard_has_saved, idCardService.getById(ID));
        verify(idCardRepository).getById(ID);
    }
}