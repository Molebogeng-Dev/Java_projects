package com.ImportPodcast.website.RESTs;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestBackend {

    //Initializing to the backend and save to db
    @PostMapping("/contact")
    private String contactRest(@RequestBody Contactdb contactDb){
        return "Form Submitted";
    }

}
