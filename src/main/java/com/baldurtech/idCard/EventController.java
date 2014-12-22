package com.baldurtech.idCard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("event")
public class EventController {
    @RequestMapping("list")
    public String list() {
        return "event/list";
    }
    
}