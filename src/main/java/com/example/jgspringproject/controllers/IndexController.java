package com.example.jgspringproject.controllers;


import com.example.jgspringproject.repositories.Commentsrepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
@Log4j2


public class IndexController {
    @Autowired
    Commentsrepository cr;
    @GetMapping("/index")
    public ModelAndView showindex(){

        System.out.println(cr.findAll()+"xsd");
        var mav = new ModelAndView( "index","list", cr.findAll());


        return mav;
    }





}
