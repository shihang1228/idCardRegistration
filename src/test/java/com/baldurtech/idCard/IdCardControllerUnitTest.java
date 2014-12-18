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
import org.springframework.web.multipart.MultipartFile;
import static org.mockito.Mockito.verify;

import org.springframework.ui.Model;

public class IdCardControllerUnitTest extends CreateIdCard{
    IdCard idCard;
    DateFormat format;
    Long ID = 23L;
    
    @Mock
    Model model;
    
    @Mock
    MultipartFile image;
    
    @Mock
    IdCardService idCardService;
    
    @InjectMocks
    IdCardController idCardController;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        idCard = createValidIdCard();
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
        assertEquals("redirect:list", idCardController.save(idCard, image));
        verify(idCardService).save(idCard);
    }
    
    @Test
    public void 调用show方法时应该返回idCard_show字符串() {
        assertEquals("idCard/show", idCardController.show(ID, model));
        verify(idCardService).getById(ID);
    }
}