package com.baldurtech.idCard;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class IdCardControllerUnitTest {
    IdCard idCard;
    DateFormat format;
     
    @InjectMocks
    IdCardController idCardController;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
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
    public void 调用list方法时应该返回idCard_list字符串() {
        assertEquals("idCard/list", idCardController.list());
    }
    
    @Test
    public void 调用create方法时应该返回idCard_create字符串() {
        assertEquals("idCard/create", idCardController.create());
    }
    
    @Test
    public void 调用save方法时应该返回redirect_list字符串() {
        assertEquals("redirect:list", idCardController.save(idCard));
    }
}