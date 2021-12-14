package com.example.jgspringproject.repositories;

import com.example.jgspringproject.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Userloginrepository extends JpaRepository<User, Integer> {
}
