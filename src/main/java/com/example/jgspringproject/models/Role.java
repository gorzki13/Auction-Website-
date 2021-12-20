package com.example.jgspringproject.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)//przechowywane w postaci łańcucha znaków
    private Types type;
    @ManyToMany(mappedBy = "roles")//właściciel relacji to roles
    private Set<User> users;

    public Role(Types type){
        this.type = type;
    }

    @Override
    public String getAuthority() {
        return type.toString();
    }

    public static enum Types{
        ROLE_ADMIN,
        ROLE_USER
    }
    /*Bezargumentowy konstruktor gettery i setery lub Lombok */


}

