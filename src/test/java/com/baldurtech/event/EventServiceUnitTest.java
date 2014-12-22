package com.baldurtech.event;

import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class EventServiceUnitTest {
    Event event;
    List<Event> eventList;
    
    @Mock
    EventRepository eventRepository;
    
    @InjectMocks
    EventService eventService;
    
    @Before 
    public void setup() {
        eventList = new ArrayList<Event>();
        event = new Event();
       
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void 调用list方法时应该返回eventList() {
        when(eventRepository.findAll()).thenReturn(eventList);
        
        assertEquals(eventList, eventService.findAll());
        verify(eventRepository).findAll();
    }
    
    @Test
    public void 调用save方法是应该返回event() {
        when(eventRepository.save(event)).thenReturn(event);
        
        assertEquals(event, eventService.save(event));
        verify(eventRepository).save(event);
    }
}

