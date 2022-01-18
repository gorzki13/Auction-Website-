package com.example.jgspringproject.controllers;

import com.example.jgspringproject.models.Discussion;
import com.example.jgspringproject.models.Role;
import com.example.jgspringproject.models.User;
import com.example.jgspringproject.repositories.Commentsrepository;
import com.example.jgspringproject.repositories.Discussionrepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashSet;

@Controller
@Log4j2
public class ForumController {



        @Autowired
        Commentsrepository cr;
    @Autowired
    Discussionrepository dr;

        @GetMapping("/forum")
        public ModelAndView showforum(){

            System.out.println(cr.findAll());
            var mav = new ModelAndView( "forum","list", cr.findAll());


            return mav;
        }

    @GetMapping("/post")
    public String showform2(Model m, @RequestParam(value = "id") int id)throws Exception {

int idd=id;
        m.addAttribute("title",cr.findById(id));
        m.addAttribute("list", dr.findByIdd(idd));


        return "post";


    }
    @PostMapping("/post")

    public String reg(@Valid @ModelAttribute("Discution") Discussion d, BindingResult result, Model m ){


        m.addAttribute("Discution",d);
d.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());

       System.out.println(d.getId());
        System.out.println(d.getIdd());
        System.out.println(d.getUsername());
        System.out.println(d.getText());
dr.save(d);
        return "redirect:post/?id="+d.getIdd();
    }
}















