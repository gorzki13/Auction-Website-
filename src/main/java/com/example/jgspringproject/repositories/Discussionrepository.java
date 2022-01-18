package com.example.jgspringproject.repositories;

import com.example.jgspringproject.models.Comments;
import com.example.jgspringproject.models.Discussion;
import com.example.jgspringproject.models.Userid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Discussionrepository extends JpaRepository<Discussion, Integer> {
    List<Discussion> findByIdd(int idd);
}
