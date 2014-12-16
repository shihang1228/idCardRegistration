package com.baldurtech.idCard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("idCard")
public class IdCardController {
    @RequestMapping(value = "list", method = RequestMethod.GET) 
    public String list() {
        return "idCard/list";
    }
}