package com.example.jgspringproject.repositories;

import com.example.jgspringproject.models.Userid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Userrepository extends JpaRepository<Userid, Integer> {
List<Userid>findByItemnameContainingIgnoreCase(String name);



}
