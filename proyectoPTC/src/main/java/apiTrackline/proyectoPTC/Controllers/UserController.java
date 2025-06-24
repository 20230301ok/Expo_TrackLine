package apiTrackline.proyectoPTC.Controllers;

import apiTrackline.proyectoPTC.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiUser")
public class UserController {

    @Autowired
    private UserService service;
}
