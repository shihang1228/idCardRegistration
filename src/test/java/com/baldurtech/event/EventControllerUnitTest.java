package com.baldurtech.event;

import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;

import org.springframework.ui.Model;   

public class EventControllerUnitTest {
    Event event;
    Long id = 5L;
    
    @Mock
    Model model;
    
    @Mock
    EventService eventService;
    
    @InjectMocks
    EventController eventController;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        event = new Event();
        event.setName("the second team of safety education sign");
    }
    
    @Test
    public void 调用list方法时应该返回event_list字符串() {
        assertEquals("event/list", eventController.list(model));
        verify(eventService).findAll();
    }
    
    @Test
    public void 调用save方法时应该返回redirect_list字符串() {
        assertEquals("redirect:list", eventController.save(event));
        verify(eventService).save(event); 
    }
    
    @Test
    public void 调用show方法时应该返回event_show字符串() {
        assertEquals("event/show", eventController.show(id, model));
        verify(eventService).show(id);
    }
}