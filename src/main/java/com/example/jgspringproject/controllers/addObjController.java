package com.example.jgspringproject.controllers;


import com.example.jgspringproject.models.CategoryData;
import com.example.jgspringproject.models.Userid;
import com.example.jgspringproject.repositories.Categoryrepository;
import com.example.jgspringproject.repositories.Userrepository;
import com.example.jgspringproject.validators.namevalidator;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



import javax.validation.Valid;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Controller
@Log4j2
@RequestMapping("/userlist")
public class addObjController {
   //testowy kom
    @Autowired
    Userrepository ur;
    @Autowired
    Categoryrepository cr;

    @GetMapping(path={"/addForm","/editForm"})
    public String showform(Model m, @RequestParam(value = "id",defaultValue = "-1",required = false) int id)throws Exception{

        if(id!=-1) {

            m.addAttribute("list", ur.findById(id));

       System.out.println("a");

        } else {
            Userid u1=new Userid ();
            m.addAttribute("list",u1);

            System.out.println("b");



        }

        return "editForm";

    }

    @PostMapping("/editForm")

    public String detailForm2(@Valid  @ModelAttribute("list") Userid list, BindingResult result, Model m,@RequestParam("fileImage") MultipartFile multipartFile ) throws IOException {

        if(result.hasErrors()){
            return "editForm";
        }
       String fileName= StringUtils.cleanPath(multipartFile.getOriginalFilename());
        list.setPhoto(fileName);
        Userid saveduserid=ur.save(list);
        String uploadDir="C:/Users/Gorzki/IdeaProjects/Auciton_SpringBoot/src/main/resources/static/"+saveduserid.getId();
        Path uploadPath= Paths.get(uploadDir);

        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }

        try( InputStream inputStream=multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);

        }catch (IOException e){


        }
        m.addAttribute("user",list);





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