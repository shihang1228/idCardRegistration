package com.baldurtech.idCard;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;
import org.springframework.web.multipart.MultipartFile;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IdCardControllerUnitTest {
    IdCard idCard = new IdCard();
    
    @Mock
    MultipartFile photo;
    
    @Mock
    IdCardService idCardService;
    
    @InjectMocks
    IdCardController idCardController;
    
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void 在idCardController中的save方法中会调用service的save方法() {
        assertEquals("redirect:list", idCardController.save(idCard, photo));
        verify(idCardService).save(idCard);
    }
}