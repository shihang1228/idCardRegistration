package com.baldurtech.idCard;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class IdCardControllerUnitTest {
    @InjectMocks
    IdCardController idCardController;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void 调用list方法时应该返回idCard_list字符串() {
        assertEquals("idCard/list", idCardController.list());
    }
    
    @Test
    public void 调用create方法是应该返回idCard_create字符串() {
        assertEquals("idCard/create", idCardController.create());
    }
}