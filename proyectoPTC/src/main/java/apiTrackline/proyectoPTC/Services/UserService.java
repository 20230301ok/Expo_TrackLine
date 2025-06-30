package apiTrackline.proyectoPTC.Services;

import apiTrackline.proyectoPTC.Controllers.UserController.User;
import apiTrackline.proyectoPTC.Entities.UserEntity;
import apiTrackline.proyectoPTC.Models.DTO.DTOUser;
import apiTrackline.proyectoPTC.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;


    // Método público que usa el repositorio y convierte entidades a DTOs
    public List<DTOUser> getData() {
        List<UserEntity> users = repo.findAll();
        return users.stream()
                .map(this::convertirAUsuarioDTO)
                .collect(Collectors.toList());
    }

    private DTOUser convertirAUsuarioDTO(UserEntity user){
        DTOUser dto = new DTOUser();
        dto.setIdUsuario(user.getIdUsuario());
        dto.setUsuario(user.getUsuario());
        dto.setContrasenia(user.getContrasenia());
        dto.setIdRol(user.getIdRol());
        return dto;
    }
}


