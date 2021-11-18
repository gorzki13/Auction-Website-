package com.example.jgspringproject.repositories;

import com.example.jgspringproject.models.Userid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepository extends JpaRepository<Userid, Integer> {




}
