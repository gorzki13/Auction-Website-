package com.example.jgspringproject.repositories;

import com.example.jgspringproject.models.User;

import com.example.jgspringproject.models.Userid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Userloginrepository extends JpaRepository<User, Integer> {
    User findByUsername(String name);


}
