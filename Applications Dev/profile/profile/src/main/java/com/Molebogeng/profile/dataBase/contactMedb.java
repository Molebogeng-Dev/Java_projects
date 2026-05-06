package com.Molebogeng.profile.dataBase;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class contactMedb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //attributes to the save on the database
    private String name;
    private String surname;
    private String email;
    private String message;

    //Spring needs this empty constructor
    public contactMedb(){}

    //Real constructor
    public contactMedb(String name, String surname, String email, String message) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.message = message;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    //Getters
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getEmail() {
        return email;
    }
    public String getMessage() {
        return message;
    }

}
