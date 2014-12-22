package com.baldurtech.event;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javax.persistence.*;

public class EventRepositoryUnitTest {
    @Mock
    EntityManager entityManager;
    
    @Mock
    TypedQuery typedQuery;
    
    @InjectMocks
    EventRepository eventRepository;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        eventRepository.setEntityManager(entityManager);
    }
    
    @Test
    public void 调用repository的findAll方法来进行显示event列表() {
        List<Event> eventList = new ArrayList<Event>();
    
        when(entityManager.createNamedQuery(Event.FIND_ALL, Event.class)).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(eventList);
        
        assertEquals(eventList, eventRepository.findAll());
        verify(entityManager).createNamedQuery(Event.FIND_ALL, Event.class);
        verify(typedQuery).getResultList();
    }
}