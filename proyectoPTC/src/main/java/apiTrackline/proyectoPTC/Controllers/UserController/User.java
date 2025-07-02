package apiTrackline.proyectoPTC.Controllers.UserController;

import apiTrackline.proyectoPTC.Models.DTO.DTOUser;
import apiTrackline.proyectoPTC.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    // Método para actualizar un usuario
    //La ruta sería localhost:8080/apiUser/updateUser
    @PutMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") long id, @RequestBody DTOUser userDto){
        return service.update(id, userDto);
    }

    @DeleteMapping("/deleteUser/{id}")
    //La ruta sería localhost:8080/apiUser/deleteUser
    public String deleteUser(@PathVariable("id") long id) {
        return service.delete(id);
    }

    @PostMapping("/postUser")
    //La ruta sería localhost:8080/apiUser/postUser
    public String postUser(@RequestBody DTOUser userDto) {
        return service.post(userDto);
    }

    @PatchMapping("/updateUserPartial/{id}")
    public String patchUser(@PathVariable Long id, @RequestBody DTOUser dto) {
        return service.patchUser(id, dto);
    }
}
