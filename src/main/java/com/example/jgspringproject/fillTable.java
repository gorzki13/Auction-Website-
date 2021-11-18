package com.example.jgspringproject;

import com.example.jgspringproject.models.CategoryData;
import com.example.jgspringproject.models.Userid;
import com.example.jgspringproject.repositories.Categoryrepository;
import com.example.jgspringproject.repositories.Userrepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class fillTable {
    @Autowired
    private Userrepository uRepository;
@Autowired
private Categoryrepository cRepository;
    @Bean
    InitializingBean init() {

        return () -> {//afterPropertiesSet
            List<CategoryData> cdl = new ArrayList<CategoryData>();
            List<Userid> ul = new ArrayList<Userid>();
            if(uRepository.findAll().isEmpty()) {
                CategoryData cd=new CategoryData("DOM");
                CategoryData cd2=new CategoryData("OGROD");
                CategoryData cd3=new CategoryData("HOBBY");
                cdl.add(cd);
                cdl.add(cd2);
                cdl.add(cd3);
                cRepository.saveAll(cdl);

                Userid u1=new Userid("Andrzej","Kowalski", LocalDate.now(),800.20f,"Telewizor",cd);
                Userid u2=new Userid("Tadeusz","Nowak", LocalDate.now(),200.99f,"Kosiarka",cd2);
                Userid u3=new Userid("Damian","JAKISTAM", LocalDate.now(),20.99f,"Wedka",cd3);
                ul.add(u1);
                ul.add(u2);
                ul.add(u3);

                uRepository.saveAll(ul);
            }
        };
    }
}





