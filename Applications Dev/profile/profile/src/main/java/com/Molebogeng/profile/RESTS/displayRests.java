package com.Molebogeng.profile.RESTS;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class displayRests {

    @GetMapping("/")
    private String contactPage(){
        return "index.html";
    }
}
