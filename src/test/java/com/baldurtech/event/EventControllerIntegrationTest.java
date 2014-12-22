package com.baldurtech.event;

import org.junit.Test; 
import org.junit.Before; 

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import com.baldurtech.config.WebAppConfigurationAware;

public class EventControllerIntegrationTest extends WebAppConfigurationAware {
    Event event;
    
    @Before
    public void setup() {
        event = new Event();
        event.setId(46L);
        event.setName("the second team of safety education sign");
    }
    
    @Test
    public void 当url为event_list时应该访问list页面() throws Exception {
        mockMvc.perform(get("/event/list"))
               .andExpect(model().attributeExists("eventList"))
               .andExpect(view().name("event/list"));
    }
    
    @Test
    public void 当url为event_create时应该访问create页面() throws Exception {
        mockMvc.perform(get("/event/create"))
               .andExpect(view().name("event/create"));
    }
    
    @Test
    public void 当url为event_save时应该重定向到list页面() throws Exception {
        mockMvc.perform(post("/event/save")
                       .param("name", event.getName()))
               .andExpect(redirectedUrl("list"));
    }
    
    @Test
    public void 但url为event_show时应该显示show页面() throws Exception {
        mockMvc.perform(get("/event/show")
                       .param("id", String.valueOf(event.getId())))
               .andExpect(model().attributeExists("event"))
               .andExpect(view().name("event/show"));
    }
}
