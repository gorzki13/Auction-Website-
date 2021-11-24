package com.example.jgspringproject.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CategoryData")


public class CategoryData {
@Id @GeneratedValue (strategy= GenerationType.IDENTITY)
    private int id;

    private  String kategoria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public CategoryData(String kategoria ,int id) {
        this.kategoria = kategoria;
    this.id=id;
    }
    public CategoryData(String kategoria ) {
        this.kategoria = kategoria;

    }

    public  String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }
}
