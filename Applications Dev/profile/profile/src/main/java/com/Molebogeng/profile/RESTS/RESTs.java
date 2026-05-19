package com.Molebogeng.profile;

import com.Molebogeng.profile.backend.Contactme;
import com.Molebogeng.profile.dataBase.contactMeRepo;
import com.Molebogeng.profile.dataBase.contactmedb;
import com.Molebogeng.profile.dataBase.diplaydb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTs {
    //wiring the database we are going to save to
    @Autowired
    contactMeRepo repo;

    //simple contact me form
    @PostMapping("/contactMe")
    public String contactMe(@RequestBody Contactme contactMe){
        //db storing data from the request body
        contactmedb form = new contactmedb(contactMe.getName(), contactMe.getSurname(), contactMe.getEmail(), contactMe.getMessage());
        //Saving to global db to repo
        repo.save(form);
        new diplaydb(repo.findAll());
        return "Form successfully submitted";
    }
}
