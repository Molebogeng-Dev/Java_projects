package co.za.KoKo.webApp.Rests;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class fController {

    @GetMapping({"/","/login","/signin"})
    public String loginPage(){
        return "forward:/index.html";
    }

}
