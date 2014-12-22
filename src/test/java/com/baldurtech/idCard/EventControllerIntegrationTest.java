package com.baldurtech.idCard;

import org.junit.Test; 

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import com.baldurtech.config.WebAppConfigurationAware;

public class EventControllerIntegrationTest extends WebAppConfigurationAware {
    
    @Test
    public void 当url为event_list时应该访问list页面() throws Exception {
        mockMvc.perform(get("/event/list"))
               .andExpect(view().name("event/list"));
    }
}
