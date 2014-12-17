package com.baldurtech.idCard;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("idCard")
public class IdCardController {

    IdCardService idCardService;
    
    @Autowired
    public IdCardController(IdCardService idCardService) {
        this.idCardService = idCardService;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET) 
    public String list() {
        return "idCard/list";
    }
    
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create() {
        return "idCard/create";
    }
    
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@ModelAttribute("idCard") IdCard idCard, 
                       @RequestParam("image") MultipartFile image) {
        try {
            idCard.setContent(image.getBytes());
            idCard.setContentType(image.getContentType());

            idCardService.save(idCard);
 
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        return "redirect:list";
    }
}