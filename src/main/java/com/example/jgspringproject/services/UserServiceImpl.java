package com.example.jgspringproject.services;

import com.example.jgspringproject.models.ProfileNames;
import com.example.jgspringproject.models.Role;
import com.example.jgspringproject.models.User;
import com.example.jgspringproject.repositories.Userloginrepository;
import com.example.jgspringproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashSet;
import java.util.Set;



@Service("userDetailsService")
@Profile(ProfileNames.USERS_IN_DATABASE)
public class UserServiceImpl implements UserService {

    @Autowired
    private Userloginrepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user  = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return user;
    }




    }




