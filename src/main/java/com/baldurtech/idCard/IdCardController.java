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
                       @RequestParam("image") MultipartFile image,
                       Model model) {
        try {
            idCard.setContent(image.getBytes());
            idCard.setContentType(image.getContentType());

            idCardService.save(idCard);
            model.addAttribute("id", idCard.getId());
        } catch(IOException e) {
            e.printStackTrace();
        }
        return "redirect:show";
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
    
    /*
    @RequestMapping(value = "index", method = RequestMethod.GET) 
    public String index(Model model) {
        IdCard idCard = idCardService.getLatestIdCard();
        while(idCardService.getLatestIdCard() != idCard) {
            System.out.println(idCard);
            System.out.println(idCardService.getLatestIdCard());
            try {
                Thread.sleep(1000);//3秒
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            model.addAttribute("id", idCard.getId());
            return "redirect:show"; 
        }
        return "idCard/index";
    }   */
    
    @RequestMapping(value = "indexOne") 
    public String indexOne() {
        return "idCard/index";
    }
}