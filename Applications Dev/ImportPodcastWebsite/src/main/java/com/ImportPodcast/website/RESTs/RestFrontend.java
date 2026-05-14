package com.ImportPodcast.website.RESTs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RestFrontend {

    //Simple welcome page
    @GetMapping("/")
    private String indexPage(){
        return "index";
    }

}
