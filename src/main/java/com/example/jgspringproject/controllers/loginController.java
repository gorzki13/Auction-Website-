package com.example.jgspringproject.controllers;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@Log4j2
public class loginController {
    @GetMapping("/login")
    public ModelAndView login(){



        return new ModelAndView( "login");
    }
    @GetMapping("/logout")
    public ModelAndView logout(){



        return new ModelAndView( "login");
    }




}