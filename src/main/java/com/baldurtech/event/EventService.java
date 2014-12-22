package com.baldurtech.event;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EventService {
    EventRepository eventRepository;
    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    
    public List<Event> findAll() {
        
        return eventRepository.findAll();
    }
    
    public Event save(Event event) {
        return eventRepository.save(event);
    }
}