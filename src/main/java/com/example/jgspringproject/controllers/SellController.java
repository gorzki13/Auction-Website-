package com.example.jgspringproject.controllers;

import com.example.jgspringproject.models.Userid;
import com.example.jgspringproject.repositories.Categoryrepository;
import com.example.jgspringproject.repositories.Userrepository;
import com.example.jgspringproject.validators.namevalidator;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Controller
@Log4j2
@PropertySource("config.properties")
public class SellController {

    @Autowired
    Userrepository ur;
    @Autowired
    Categoryrepository cr;



    @InitBinder("list")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new namevalidator());
    }

    @GetMapping("/sellform")
    public String showform2(Model m, @RequestParam(value = "id") int id)throws Exception {


        m.addAttribute("dane", ur.findByid(id));


        return "sellform";


    }

    @GetMapping("/buydetails")
    public String showform4(Model m, @RequestParam(value = "id") int id)throws Exception {

 Userid u=ur.findByid(id);
 u.setBuy(true);

 u.setBuyer(SecurityContextHolder.getContext().getAuthentication().getName());
 ur.save(u);
        m.addAttribute("dane", u);

        return "buydetails";


    }







}
