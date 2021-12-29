package com.example.jgspringproject.controllers;

import com.example.jgspringproject.models.Userid;
import com.example.jgspringproject.repositories.Categoryrepository;
import com.example.jgspringproject.repositories.Userrepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@Log4j2
public class myauctionController {
    @Autowired
    Userrepository userrepository;
    @Autowired
    Categoryrepository cr;
    @GetMapping("/myauction")

    public ModelAndView myauction(){


        var mav = new ModelAndView( "myauction","list", userrepository.findBySellerID(SecurityContextHolder.getContext().getAuthentication().getName()));


        return mav;
    }

    @GetMapping("/delete")
    public String delete(Model m, @RequestParam(value = "id") int id)throws Exception {

        userrepository.deleteById(id);


        return "deletedetails";


    }




}