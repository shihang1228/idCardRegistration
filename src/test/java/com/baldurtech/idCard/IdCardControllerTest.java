package com.baldurtech.idCard;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.Before;

import java.text.SimpleDateFormat;
import java.text.DateFormat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.mock.web.MockMultipartFile;
import com.baldurtech.config.WebAppConfigurationAware;

public class IdCardControllerTest extends WebAppConfigurationAware {
    private IdCard idCard;
    private DateFormat  format;
    MockMultipartFile photo = new MockMultipartFile("photo","photo.jpg", "image/jpeg", "somexml".getBytes());
    
    @Before
    public void setup() {
        format = new SimpleDateFormat("yyyy-MM-dd");
        idCard = new IdCard();
        idCard.setName("XiaoBai");
        idCard.setFolk("Han");
        idCard.setGender("Female");
        idCard.setBirthday(java.sql.Date.valueOf("2007-01-12"));
        idCard.setAddress("TaiYuan");
        idCard.setAgency("Xiaodian Paichusuo");
        idCard.setCode("100000000000000000");
    }
    
    @Ignore
    @Test
    public void 当URL为idCard_add时应该访问create页面() throws Exception {
        mockMvc.perform(get("/idCard/add"))
               .andExpect(view().name("idCard/add"));
    }
    
    @Test 
    public void 当URL为idCard_list时应该访问list页面() throws Exception {
        mockMvc.perform(get("/idCard/list"))
               .andExpect(view().name("idCard/list"));
    }
    
    @Test
    public void 当提交表单时应该重定向到list页面() throws Exception {
        mockMvc.perform(fileUpload("/idCard/save")
                        .file(photo)
                        .param("name", idCard.getName())
                        .param("folk", idCard.getFolk())
                        .param("code", idCard.getCode())
                        .param("birthday", format.format(idCard.getBirthday()))
                        .param("address", idCard.getAddress())
                        .param("agency", idCard.getAgency())
                        .param("gender", idCard.getGender()))
               .andExpect(redirectedUrl("list"));
    }
}