package com.ImportPodcast.website.RESTs.Backend;

public class Contactdb {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public Contactdb(){}

    public Contactdb(String firstName, String lastName, String email, String phone){
        this.firstName = firstName;
        this.lastName= lastName;
        this.email = email;
        this.phone = phone;

    }

    //setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    //Getters
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
}
