package com.example.jgspringproject.controllers;

import com.example.jgspringproject.models.UserList;
import com.example.jgspringproject.models.Userid;
import com.example.jgspringproject.repositories.Userrepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Controller
@Log4j2
public class UserController {
    @Autowired
    Userrepository userrepository;

    @GetMapping("/userlist")

    public ModelAndView userlist(){


        var mav = new ModelAndView( "userlist","list", userrepository.findAll());


        return mav;
    }

    @GetMapping(path="/userlist.html", params={"did"})
    public String deleteVehicle(int did){
        userrepository.deleteById(did);
        return "redirect:userlist.html";
    }








}
