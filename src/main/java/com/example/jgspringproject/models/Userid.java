package com.example.jgspringproject.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Userid")


public class Userid {
  @NotNull
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
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<CategoryData> cd;

    public Userid(int id, String name, String surname, LocalDate date, float wallet, String itemname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.wallet = wallet;
        this.itemname = itemname;
        this.cd=new HashSet<>();
    }


}
