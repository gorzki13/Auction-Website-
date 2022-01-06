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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedQuery(name = "Userid.findByName",
        query = "select u from Userid u where u.name like ?1")
@NamedQuery(name = "Userid.findBySurname",
        query = "select u from Userid u where u.surname like ?1")
@NamedQuery(name = "Userid.findByDate",
        query = "select u from Userid u where u.date = ?1")
@NamedQuery(name = "Userid.findByWallet",
        query = "select u from Userid u where u.wallet = ?1")
@NamedQuery(name = "Userid.findByitemname",
        query = "select u from Userid u where u.itemname like ?1")
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
    @Column(name = "sellerID", nullable = false)
   private String sellerID;

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
    @Column(name = "accountNumber", nullable = true)
    private String accountNumber;
    @Column(name = "description", nullable = false)
    private String desctription;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<CategoryData> cd;
    @Column(name = "photo", nullable = true)
    private String photo;
    @Column(name = "buyer", nullable = true)
    private String buyer;
    @Column(name = "buy", nullable = false)
    private boolean buy;
    public String getImagePath(){
        if(photo==null)
            return null;
        String path ="/"+id+"/"+photo;
        Path p= Paths.get(path);
        return p.toString();

    }
    public Userid(int id, String name, String surname, LocalDate date, float wallet, String itemname,String photo,String SellerID,String desctription,String accountNumber) {
       this.accountNumber=accountNumber;
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.wallet = wallet;
        this.itemname = itemname;
        this.photo=photo;
      this.sellerID=SellerID;
        this.desctription=desctription;
        this.buy=false;

        this.cd=new HashSet<>();
    }


}
