package com.example.jgspringproject;

import com.example.jgspringproject.models.CategoryData;
import com.example.jgspringproject.models.Role;
import com.example.jgspringproject.models.User;
import com.example.jgspringproject.models.Userid;
import com.example.jgspringproject.repositories.Categoryrepository;
import com.example.jgspringproject.repositories.Rolerepository;
import com.example.jgspringproject.repositories.Userloginrepository;
import com.example.jgspringproject.repositories.Userrepository;
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

                Userid u1=new Userid(1,"Andrzej","Kowalski", LocalDate.now(),800.20f,"Telewizor","","admin","bardzo dobry model polecam");

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
            }





        };
    }
}





