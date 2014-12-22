package com.baldurtech.event;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("event")
public class EventController {
    EventService eventService;
    
    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    
    @RequestMapping("list")
    public String list(Model model) {   
        model.addAttribute("eventList", eventService.findAll());
        return "event/list";
    }
}