package com.baldurtech.idCard;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
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
    
    @RequestMapping(value = "show", method = RequestMethod.GET)
    public String show(@RequestParam("id") Long id, Model model) {
        model.addAttribute("idCard", idCardService.getById(id));  
        return "idCard/show";
    }
    
    @RequestMapping(value = "image", method = RequestMethod.GET)
    public @ResponseBody void showImage(@RequestParam("id") Long id, HttpServletResponse resp) {
        try {
            IdCard idCard = idCardService.getById(id);
            
            resp.setContentType(idCard.getContentType());
            OutputStream out = resp.getOutputStream();
            out.write(idCard.getContent());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}