package co.za.KoKo.webApp.Rests;

import co.za.KoKo.webApp.Rests.backendClass.apiRegister;
import co.za.KoKo.webApp.Rests.backendDbClass.apiRegisterDb;
import co.za.KoKo.webApp.Rests.backendDbClass.apiRegisterDbRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class bController {
    @Autowired
    private apiRegisterDbRepo repo;

    @PostMapping("/auth/register")
    public String apiRegister(@RequestBody apiRegister api){
        apiRegisterDb dataBase = new apiRegisterDb(api.getName(),api.getEmail(),api.getPhone(),api.getPassword());
        repo.save(dataBase);
        return "User saved successfully";
    }
}
