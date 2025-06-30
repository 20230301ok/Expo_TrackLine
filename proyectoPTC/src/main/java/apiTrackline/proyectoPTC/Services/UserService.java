package apiTrackline.proyectoPTC.Services;

import apiTrackline.proyectoPTC.Models.DTO.UserDTO;
import apiTrackline.proyectoPTC.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<UserDTO> getAllUsers(){
        List<UserEntity> usuarios = repo.findAll();
        return usuarios.stream()
                .map(this::convertirUsuarioDTO)
                .collect(Collectors.toList());
    }
}
