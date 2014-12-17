package com.baldurtech.idCard;

import org.junit.Test; 
import org.junit.Before;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.baldurtech.config.WebAppConfigurationAware;

public class IdCardControllerIntegrationTest extends WebAppConfigurationAware {
    IdCard idCard;
    DateFormat format;
    
    @Before
    public void setup() {
        format = new SimpleDateFormat("yyyy-MM-dd");
    
        idCard = createValidIdCard();
    }
    
    @Test
    public void 当url为idCard_list时应该访问list页面() throws Exception {
        mockMvc.perform(get("/idCard/list"))
               .andExpect(view().name("idCard/list"));
    }
    
    @Test
    public void 当url为idCard_create时应该访问create页面() throws Exception {
        mockMvc.perform(get("/idCard/create"))
               .andExpect(view().name("idCard/create"));
    }
    
    @Test
    public void 当url为idCard_save时应该重定向到list页面() throws Exception {
        mockMvc.perform(post("/idCard/save")
                       .param("name", idCard.getName())
                       .param("folk", idCard.getFolk())
                       .param("gender", idCard.getGender())
                       .param("birthday", format.format(idCard.getBirthday()))
                       .param("agency", idCard.getAgency())
                       .param("address", idCard.getAddress())
                       .param("code", idCard.getCode()))
               .andExpect(redirectedUrl("list"));
    }
}