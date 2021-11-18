package com.example.jgspringproject.controllers;

import com.example.jgspringproject.models.CategoryData;
import com.example.jgspringproject.models.UserList;
import com.example.jgspringproject.models.Userid;
import com.example.jgspringproject.repositories.Categoryrepository;
import com.example.jgspringproject.repositories.Userrepository;
import com.example.jgspringproject.validators.namevalidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller

@RequestMapping("/userlist")
public class addObjController {
    @Autowired
    Userrepository ur;
    @Autowired
    Categoryrepository cr;
    @GetMapping(path={"/addForm","/editForm"})
    public String showform(Model m, @RequestParam(value = "id") Optional<Integer> id)throws Exception{

        if(id.isPresent()) {
            int userId=id.get();
            m.addAttribute("list", ur.findById(userId));

       System.out.println("a");

        } else {
            Userid u1=new Userid (UserList.getUid(),"","",null,0,null,null,0);
            m.addAttribute("list",u1);

            System.out.println("b");
            UserList.setUid(UserList.getUid()+1);


        }

        return "editForm";

    }

    @PostMapping("/editForm")

    public String detailForm2(@Valid  @ModelAttribute("list") Userid list, BindingResult result, Model m ){

        if(result.hasErrors()){
            return "editForm";
        }
        m.addAttribute("user",list);
        ur.save(list);
        return "Objdetails";
    }
    @InitBinder("list")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new namevalidator());
    }




@ModelAttribute("kategorie")
    public List<CategoryData> retCategory(){
        List <CategoryData> a=new ArrayList<CategoryData>();
      a=cr.findAll();
return a;
    }




}