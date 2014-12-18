package com.baldurtech.idCard;

import org.junit.Test; 
import org.junit.Before;
import org.junit.Ignore;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.mock.web.MockMultipartFile;

import com.baldurtech.config.WebSecurityConfigurationAware;

public class IdCardControllerIntegrationTest extends WebSecurityConfigurationAware {
    IdCard idCard;
    DateFormat format;
    Long ID = 14L;
    
    MockMultipartFile image;
    
    public MockHttpServletRequestBuilder postIdCardTo(String url) {
        return post(url).param("name", idCard.getName())
                         .param("folk", idCard.getFolk())
                         .param("gender", idCard.getGender())
                         .param("birthday", format.format(idCard.getBirthday()))
                         .param("agency", idCard.getAgency())
                         .param("address", idCard.getAddress())
                         .param("code", idCard.getCode());
    }
    
    @Before
    public void setup() {
        image = new MockMultipartFile("image","image.jpg", "image/jpeg", "image".getBytes());
        format = new SimpleDateFormat("yyyy-MM-dd");
    
        idCard = createValidIdCard();
    }
    
    @Test
    public void 当角色为user时url为idCard_list时应该访问list页面() throws Exception {
        userPerform(get("/idCard/list"))
               .andExpect(view().name("idCard/list"));
    }
    
    @Test
    public void 当角色为admin时url为idCard_create时应该访问create页面() throws Exception {
        adminPerform(get("/idCard/create"))
               .andExpect(view().name("idCard/create"));
    }
    
    @Test @Ignore
    public void 当角色为user时url为idCard_save时应该重定向到list页面() throws Exception {
        userPerform(fileUpload("/idCard/save")
                    .file(image)
                    .param("name", idCard.getName())
                    .param("folk", idCard.getFolk())
                    .param("gender", idCard.getGender())
                    .param("birthday", format.format(idCard.getBirthday()))
                    .param("agency", idCard.getAgency())
                    .param("address", idCard.getAddress())
                    .param("code", idCard.getCode()))
               .andExpect(redirectedUrl("list"));
    }
    
    public void 当角色为user时url为idCard_show时应该访问show页面() throws Exception {
        userPerform(get("/idCard/show")
                    .param("id", String.valueOf(ID)))
               .andExpect(view().name("idCard/show"));
    }
}