package com.example.jgspringproject.controllers;

import com.example.jgspringproject.models.Userid;
import com.example.jgspringproject.repositories.Categoryrepository;
import com.example.jgspringproject.repositories.Userrepository;
import com.example.jgspringproject.validators.namevalidator;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

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







}
