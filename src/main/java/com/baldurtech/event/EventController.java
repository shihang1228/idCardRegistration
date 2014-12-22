package com.baldurtech.event;

import java.sql.Date;
import java.util.List;
import java.util.ArrayList;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("event")
public class EventController {
    @RequestMapping("list")
    public String list(Model model) {   
        List<Event> eventList = new ArrayList<Event>();
        
        Event event1 = new Event();
        
        event1.setDateCreated(Date.valueOf("2007-01-12"));
        event1.setName("Safety education sign for second Team");
        
        Event event2= new Event();
        
        event2.setDateCreated(Date.valueOf("2007-05-12"));
        event2.setName("Safety education sign for first Team");
        
        eventList.add(event1);
        eventList.add(event2);
        
        model.addAttribute("eventList", eventList);
        return "event/list";
    }
}