package apiTrackline.proyectoPTC.Controllers.UserController;

import apiTrackline.proyectoPTC.Models.DTO.DTOUser;
import apiTrackline.proyectoPTC.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apiUser")
public class User {
    @Autowired //Inyectamos la clase UserService
    private UserService service;

    //Se usa GetMapping porque es el metodo HTTP que usaremos
    //La ruta sería localhost:8080/apiUser/dataUser
    @GetMapping("/dataUser")
    public List<DTOUser> getUser(){
        return service.getData();
    }
}
