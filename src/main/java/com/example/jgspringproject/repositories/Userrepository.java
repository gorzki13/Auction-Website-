package com.example.jgspringproject.repositories;

import com.example.jgspringproject.models.Userid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.NamedQuery;
import java.time.LocalDate;
import java.util.List;

public interface Userrepository extends JpaRepository<Userid, Integer> {
List<Userid>findByItemnameContainingIgnoreCase(String name);
List<Userid>findByName(String name);
    List<Userid>findBySurname(String surname);
    List<Userid>findByDate(LocalDate date);
    List<Userid>findByWallet(float wallet);
    List<Userid>findByitemname(String itemname);

    @Query("select u from Userid u where u.name like ?1")
    List<Userid>findByName2(String name);
    @Query("select u from Userid u where u.surname like ?1")
    List<Userid>findBySurname2(String surname);
    @Query("select u from Userid u where u.date = ?1")
    List<Userid>findByDate2(LocalDate date);
    @Query("select u from Userid u where u.wallet >= ?1 and u.wallet <= ?2")
    List<Userid>findByWallet2(float min,float max);
    @Query("select u from Userid u where u.itemname like ?1")
    List<Userid>findByitemname2(String itemname);
}
