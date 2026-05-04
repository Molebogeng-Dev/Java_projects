package com.Molebogeng.profile;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTs {

    //simple display of my index
    @GetMapping("/index")
    public String index(){
        return "Explore Molebogeng Lehlogonolo Selahle";
    }

    //simple contact me form
    @PostMapping("/contactMe")
    public String contactMe(@RequestBody ContactMe contactMe){

        return "Form successfully loaded";
    }
}
