package com.example.jgspringproject;

import com.example.jgspringproject.models.*;
import com.example.jgspringproject.repositories.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.HashSet;
import java.util.List;

@Configuration
public class fillTable {
    @Autowired
    private  PasswordEncoder passwordEncoder;
    @Autowired
    private Userrepository uRepository;
@Autowired
private Categoryrepository cRepository;
  @Autowired
  private Userloginrepository Userloginrepository;
    @Autowired
    private Rolerepository rolerepository;
    @Autowired
    private Commentsrepository Commentsrepository;
    @Autowired
    private Discussionrepository Discussionrepository;
    @Bean
    InitializingBean init() {

        return () -> {//afterPropertiesSet
            List<CategoryData> cdl = new ArrayList<CategoryData>();
            List<Userid> ul = new ArrayList<Userid>();
            if(cRepository.findAll().isEmpty()) {
                CategoryData cd=new CategoryData("DOM");
                CategoryData cd2=new CategoryData("OGROD");
                CategoryData cd3=new CategoryData("HOBBY");
                cdl.add(cd);
                cdl.add(cd2);
                cdl.add(cd3);
                cRepository.saveAll(cdl);

                Userid u1=new Userid(1,"Andrzej","Kowalski", LocalDate.now(),800.20f,"Telewizor","","admin","bardzo dobry model polecam","123456789");

                ul.add(u1);


                uRepository.saveAll(ul);
            }
            if(rolerepository.findAll().isEmpty()&& Userloginrepository.findAll().isEmpty()) {
                Role roleUser = rolerepository.save(new Role(Role.Types.ROLE_USER));
                Role roleAdmin = rolerepository.save(new Role(Role.Types.ROLE_ADMIN));

                User user = new User("user", true);
                user.setRoles(new HashSet<>(Arrays.asList(roleUser)));
                user.setPassword(passwordEncoder.encode("user"));

                User admin = new User("admin", true);
                admin.setRoles(new HashSet<>(Arrays.asList(roleAdmin)));
                admin.setPassword(passwordEncoder.encode("admin"));

                User test = new User("superuser", true);
                test.setRoles(new HashSet<>(Arrays.asList(roleAdmin, roleUser)));
                test.setPassword(passwordEncoder.encode("superuser"));


                Userloginrepository.save(user);
                Userloginrepository.save(admin);
                Userloginrepository.save(test);
               Discussion d=new Discussion(1,1,"admin","polecam zainteresować się marką xiaomi spory wybór mają");
                Discussion d2=new Discussion(2,2,"Krzychu12","ewidentnie neato");

                Comments c=new Comments(1,"Telefony komórkowe","jaki telefon do 1000 zł ?");
                Comments c2=new Comments(2,"Odkurzacz","xiaomi vs neato");
                List<Discussion> Disclist = new ArrayList<Discussion>();
               Disclist.add(d);
                Disclist.add(d2);
              Discussionrepository.saveAll(Disclist);

                List<Comments> comlist = new ArrayList<Comments>();
                comlist.add(c);
                comlist.add(c2);

                Commentsrepository.saveAll(comlist);
            }





        };
    }
}





