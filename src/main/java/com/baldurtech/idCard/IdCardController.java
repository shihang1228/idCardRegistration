package com.baldurtech.idCard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("idCard")
public class IdCardController {
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add() {
        return "idCard/add";
    }
}