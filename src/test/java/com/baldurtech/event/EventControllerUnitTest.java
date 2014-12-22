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
    @Mock
    Model model;
    
    @Mock
    EventService eventService;
    
    @InjectMocks
    EventController eventController;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void 调用list方法时应该返回event_list字符串() {
        assertEquals("event/list", eventController.list(model));
        verify(eventService).findAll();
    }
}