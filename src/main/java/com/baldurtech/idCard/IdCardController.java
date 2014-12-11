package com.baldurtech.idCard;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;

@Controller
@RequestMapping("idCard")
public class IdCardController {
    IdCardService idCardService;
    
    @Autowired
    public IdCardController(IdCardService idCardService) {
        this.idCardService = idCardService;
    }
    
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
        
        try {
            idCard.setContent(photo.getBytes());
            idCard.setContentType(photo.getContentType());
            
            idCardService.save(idCard);
        } catch(IOException e) {
            e.printStackTrace();
        }
        
       return "redirect:list";
    }
}