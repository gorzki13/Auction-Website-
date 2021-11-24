package com.example.jgspringproject.controllers.filters;

import com.example.jgspringproject.repositories.Userrepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Log4j2
@Controller
@AllArgsConstructor
public class NameFilter {
private final Userrepository ur;
@GetMapping(value ="/znajdz")
public String searchNameByPharse (Optional<String> phrase, Model model){
var list=ur.findByItemnameContainingIgnoreCase(phrase.orElse(""));
model.addAttribute("list",list);


return "/userlist";
}
}