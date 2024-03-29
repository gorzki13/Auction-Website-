package com.example.jgspringproject.controllers;

import com.example.jgspringproject.models.User;
import com.example.jgspringproject.models.Userid;
import com.example.jgspringproject.repositories.Categoryrepository;
import com.example.jgspringproject.repositories.Userloginrepository;
import com.example.jgspringproject.repositories.Userrepository;
import com.example.jgspringproject.validators.namevalidator;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Controller
@Log4j2

public class SellController {
    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    Userrepository ur;
    @Autowired
    Userloginrepository ulr;
    @Autowired
    Categoryrepository cr;



    @InitBinder("list")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new namevalidator());
    }

    @GetMapping("/sellform")
    public String showform2(Model m, @RequestParam(value = "id") int id)throws Exception {


        m.addAttribute("dane", ur.findByid(id));


        return "sellform";


    }

    @GetMapping("/buydetails")
    public String showform4(Model m, @RequestParam(value = "id") int id)throws Exception {

 Userid u=ur.findByid(id);
 u.setBuy(true);

 u.setBuyer(SecurityContextHolder.getContext().getAuthentication().getName());
 ur.save(u);
        m.addAttribute("dane", u);
        String filepath=".src\\main\\resources\\pdfjava";

     User buyer=ulr.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()) ;
String email= buyer.getEmail();

String text=
        " Hej "+buyer.getUsername()+
        "\nWłaśnie Kupiłeś produkt od użytkownika : "+ SecurityContextHolder.getContext().getAuthentication().getName()+
        "\n Nazwa produktu : "+u.getItemname()+
        "\n Należność : "+u.getWallet()+" ZŁ"+"\n"+"\n"+
        "\n Dane do przelewu :"+
        "\n Imie :"+u.getName()+
        "\n Nazwisko :"+u.getSurname()+
        "\n numer konta : IBAN:{"+u.getAccountNumber()+"}";

try {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom("sprzedawaj.pl@gmail.com");
    message.setTo(email);
    message.setSubject("Sprzedawaj.pl Szczegóły tranzakcji !");
    message.setText(text);
    emailSender.send(message);
}catch (Exception e){
    System.out.println("użytkownik nie ma maila");
}





        return "buydetails";


    }







}
