package com.ImportPodcast.website.RESTs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RestFrontend {

    //Simple welcome page
    @GetMapping("/home")
    private String indexPage(){
        return "index.html";
    }

    @GetMapping("/links")
    private String linkPage(){
        return "links.html";
    }
}
