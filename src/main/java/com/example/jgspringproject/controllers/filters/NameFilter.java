package com.example.jgspringproject.controllers.filters;

import com.example.jgspringproject.repositories.Userrepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.Optional;

@Log4j2
@Controller
@AllArgsConstructor
public class NameFilter {
    private final Userrepository ur;

    @GetMapping(value = "/znajdz")
    public String searchNameByPharse(Optional<String> phrase,String filter, Model model) {
        var list = ur.findByItemnameContainingIgnoreCase(phrase.orElse(""));
        model.addAttribute("list", list);
        int choice_int = Integer.parseInt(filter);
        switch(choice_int){
            case 0:
                model.addAttribute("list", ur.findByName("%" + phrase.get() + "%"));
                break;
            case 1:
                model.addAttribute("list", ur.findBySurname("%" + phrase.get() + "%"));
                break;
            case 2:
                model.addAttribute("list", ur.findByDate(LocalDate.parse(phrase.get())));

                break;
            case 3:

                model.addAttribute("list", ur.findByWallet(Float.parseFloat(phrase.get())));
                break;
            case 4:
                model.addAttribute("list", ur.findByitemname("%" + phrase.get() + "%"));
                break;
            default: break;
        }


        return "/userlist";
    }
}