package com.example.jgspringproject.models;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
@Entity
@Table(name = "Userid")


public class Userid {
    @Id @GeneratedValue (strategy=GenerationType.IDENTITY)
private int id;
@Valid
    @NotEmpty @NotBlank
@Column(name = "name", nullable = false)
    private String name;
    @NotEmpty  @NotBlank
    @Column(name = "surname", nullable = false)
    private String surname;
    @Column(name = "date", nullable = false)
   @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @Column(name = "wallet", nullable = false)
    @NumberFormat(pattern = "#.00")
    private float wallet;
    @NotEmpty
    @Column(name = "itemname", nullable = false)
    private String itemname;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="type_id", nullable = false)
    private CategoryData cd;

    public CategoryData getCd() {
        return cd;
    }

    public void setCd(CategoryData cd) {
        this.cd = cd;
    }

    public Userid(String name, String surname, LocalDate date, float wallet, String itemname, CategoryData cd) {
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.wallet = wallet;
        this.itemname = itemname;
        this.cd = cd;
    }

    public Userid(int id, String name, String surname, LocalDate date, float wallet, String itemname, String kategoria, int katid) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.wallet = wallet;
        this.itemname = itemname;
        this.cd=new CategoryData(kategoria,katid);
    }
public Userid(){

}



    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public float getWallet() {
        return wallet;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }
}
