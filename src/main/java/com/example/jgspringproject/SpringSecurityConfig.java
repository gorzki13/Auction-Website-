package com.example.jgspringproject;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        auth.inMemoryAuthentication().passwordEncoder(encoder).withUser("username").password(encoder.encode("password")).roles("USER");
        auth.inMemoryAuthentication().passwordEncoder(encoder).withUser("admin").password(encoder.encode("password")).roles("ADMIN");
        auth.inMemoryAuthentication().passwordEncoder(encoder).withUser("admin2").password(encoder.encode("password")).roles("ADMIN","USER");

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
        .authorizeRequests()
                .antMatchers("/templates/userlist","/static/**", "/signup").permitAll()
                .antMatchers("/templates/editForm").hasRole("ADMIN").anyRequest().authenticated();
        http.logout().permitAll();
        http.formLogin().loginPage("/login").permitAll();


    }

}
