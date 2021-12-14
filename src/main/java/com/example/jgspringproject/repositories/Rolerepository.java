package com.example.jgspringproject.repositories;

import com.example.jgspringproject.models.Role;
import com.example.jgspringproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface Rolerepository  extends JpaRepository<Role, Integer> {
}
