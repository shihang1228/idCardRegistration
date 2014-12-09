package com.baldurtech.idCard;

import org.junit.Test;
import org.junit.Ignore;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.baldurtech.config.WebAppConfigurationAware;

public class IdCardControllerTest extends WebAppConfigurationAware {
    @Test
    public void 当URL为idCard_add时应该访问create页面() throws Exception {
        mockMvc.perform(get("/idCard/add"))
               .andExpect(view().name("idCard/add"));
    }
}