package com.example.jgspringproject.repositories;

import com.example.jgspringproject.models.CategoryData;
import com.example.jgspringproject.models.Userid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Categoryrepository extends JpaRepository<CategoryData, Integer> {




}