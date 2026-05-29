package co.za.KoKo.webApp.Rests;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class bController {

    @PostMapping("/auth/register")
    public String apiRegister(@RequestBody apiRegister api ){

    }
}
