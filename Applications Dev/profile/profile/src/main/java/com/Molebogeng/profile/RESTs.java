package com.Molebogeng.profile;

import com.Molebogeng.profile.backend.ContactMe;
import com.Molebogeng.profile.dataBase.contactMeRepo;
import com.Molebogeng.profile.dataBase.contactMedb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTs {
    //wiring the database we are going to save to
    @Autowired
    contactMeRepo repo;

    //simple display of my index
    @GetMapping("/home")
    public String home(){
        return "Explore Molebogeng Lehlogonolo Selahle";
    }

    //simple contact me form
    @PostMapping("/contactMe")
    public String contactMe(@RequestBody ContactMe contactMe){
        //db storing data from the request body
        contactMedb form = new contactMedb(contactMe.getName(), contactMe.getSurname(), contactMe.getEmail(), contactMe.getMessage());
        //Saving to global db to repo
        repo.save(form);
        return "Form successfully submitted";
    }
}
