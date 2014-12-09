package com.baldurtech.idCard;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("idCard")
public class IdCardController {
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add() {
        return "idCard/add";
    }
    
    @RequestMapping(value = "list", method = RequestMethod.GET) 
    public String list() {
        return "idCard/list";
    }
    
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@ModelAttribute("idCard") IdCard idCard,
                       @RequestParam("photo") MultipartFile photo) {
       System.out.println(idCard.getName());
       System.out.println(idCard.getFolk());
       System.out.println(idCard.getGender());
       System.out.println(idCard.getBirthday());
       System.out.println(idCard.getAddress());
       System.out.println(idCard.getAgency());
       System.out.println(idCard.getContent());
       System.out.println(idCard.getContentType());
       System.out.println(photo);
       return "redirect:list";
    }
}