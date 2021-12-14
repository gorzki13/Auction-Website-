package com.example.jgspringproject;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {





        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Bean
        public UserDetailsService userDetailsService(
                PasswordEncoder passwordEncoder) {

            InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
            User.UserBuilder userBuilder = User.builder();

            UserDetails user = userBuilder
                    .username("username")
                    .password(passwordEncoder.encode("password"))
                    .roles("USER")
                    .build();
            UserDetails admin = userBuilder
                    .username("admin")
                    .password(passwordEncoder.encode("password"))
                    .roles("ADMIN")
                    .build();
            UserDetails admin2 = userBuilder
                    .username("admin2")
                    .password(passwordEncoder.encode("password"))
                    .roles("ADMIN","USER")
                    .build();
            manager.createUser(user);
            manager.createUser(admin);
            manager.createUser(admin2);
            return manager;
        }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
        .authorizeRequests()
                .antMatchers("/userlist**","/","/stylecss/**", "/signup").permitAll()
                .antMatchers("/userlist/editForm**").hasRole("ADMIN").anyRequest().authenticated();

        http.logout().permitAll();
        http.formLogin().loginPage("/login").permitAll();
        http.exceptionHandling().accessDeniedPage("/error403");

        http.csrf().disable();



    }

}
