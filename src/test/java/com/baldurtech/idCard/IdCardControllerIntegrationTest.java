package com.baldurtech.idCard;

import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.baldurtech.config.WebAppConfigurationAware;

public class IdCardControllerIntegrationTest extends WebAppConfigurationAware {
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
}