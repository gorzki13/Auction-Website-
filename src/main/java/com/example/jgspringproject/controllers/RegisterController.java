package com.example.jgspringproject.controllers;

import com.example.jgspringproject.models.Role;
import com.example.jgspringproject.models.User;
import com.example.jgspringproject.models.Userid;
import com.example.jgspringproject.repositories.Rolerepository;
import com.example.jgspringproject.repositories.Userloginrepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashSet;

@Controller
@Log4j2

public class RegisterController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    Userloginrepository lr;
    @Autowired
    private Rolerepository rr;

    @GetMapping(path = {"/register"})
    public String showform(Model m) throws Exception {


        return "register";

    }

    @PostMapping("/register")

    public String reg(@Valid  @ModelAttribute("User") User u, BindingResult result, Model m ){

        if(result.hasErrors()){
            return "register";
        }
        m.addAttribute("User",u);
        Role roleUser = rr.save(new Role(Role.Types.ROLE_USER));
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        u.setRoles(new HashSet<>(Arrays.asList(roleUser)));
        lr.save(u);

        return "registerDetails";
    }
}



