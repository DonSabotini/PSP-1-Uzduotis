package com.psp.Lab3.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int userId;

    private String name;
    private String lastname;
    private String phonenumber;
    private String email;
    private String adress;
    private String password;

    public User(String name, String lastname, String phonenumber, String email, String adress, String password) {
        this.name = name;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.email = email;
        this.adress = adress;
        this.password = password;
    }
}
