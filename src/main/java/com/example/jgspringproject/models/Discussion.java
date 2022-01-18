package com.example.jgspringproject.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Discussion")
public class Discussion {
    @NotNull
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column (name="idd")
    private int idd;
    @Column(name = "username")
    private String username;
    @Column(name = "text")
    private String text;

}
