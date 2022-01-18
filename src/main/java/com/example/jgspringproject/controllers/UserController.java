package com.example.jgspringproject.controllers;

import com.example.jgspringproject.models.Userid;
import com.example.jgspringproject.repositories.Categoryrepository;
import com.example.jgspringproject.repositories.Userrepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@Log4j2
public class UserController {
    @Autowired
    Userrepository userrepository;
    @Autowired
    Categoryrepository cr;
    @GetMapping("/userlist")

    public ModelAndView userlist(){


        List<Userid> a=  userrepository.findAll();
        List<Userid> b=new ArrayList<>();
        System.out.println(a);

        for(int i=0;i<a.size();i++){

            if(a.get(i).getBuyer()==null){

                b.add(a.get(i));
            }
        }


        var mav = new ModelAndView( "userlist","list", b);


        return mav;
    }





}






