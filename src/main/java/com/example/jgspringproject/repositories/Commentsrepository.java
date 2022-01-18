package com.example.jgspringproject.repositories;

import com.example.jgspringproject.models.Comments;
import com.example.jgspringproject.models.Role;
import com.example.jgspringproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Commentsrepository extends JpaRepository<Comments, Integer> {
    Comments findById(int id);

}
