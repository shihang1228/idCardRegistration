package com.baldurtech.event;

import java.sql.Date;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

@Repository
public class EventRepository {
    public List<Event> findAll() {
        List<Event> eventList = new ArrayList<Event>();
        
        Event event1 = new Event();
        
        event1.setDateCreated(Date.valueOf("2007-01-12"));
        event1.setName("Safety education sign for second Team");
        
        Event event2= new Event();
        
        event2.setDateCreated(Date.valueOf("2007-05-12"));
        event2.setName("Safety education sign for first Team");
        
        eventList.add(event1);
        eventList.add(event2);
        
        return eventList;
    }
}