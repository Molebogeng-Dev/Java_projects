package com.Molebogeng.profile.backend;

public class ContactMe {
    //attributes to the form
    private String name;
    private String surname;
    private String email;
    private String message;

    //Silent constructor for spring to recognize
    public ContactMe(){}

    //Real constructor
    public ContactMe(String name, String surname, String email, String message) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.message = message;
    }

    //Setters
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
