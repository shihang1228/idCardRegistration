package com.baldurtech.event;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    
    @RequestMapping("create")
    public String create() {
        return "event/create";
    }
    
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@ModelAttribute("event") Event event) {
        eventService.save(event);
        return "redirect:list";
    }
}