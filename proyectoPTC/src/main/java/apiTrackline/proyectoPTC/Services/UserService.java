package apiTrackline.proyectoPTC.Services;

import apiTrackline.proyectoPTC.Entities.UserEntity;
import apiTrackline.proyectoPTC.Models.DTO.DTOUser;
import apiTrackline.proyectoPTC.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public String update(long id, DTOUser userDto){
        Optional<UserEntity> optionalUser = repo.findById(id);
        if (optionalUser.isPresent()) {
            UserEntity user = optionalUser.get();
            user.setUsuario(userDto.getUsuario());
            user.setContrasenia(userDto.getContrasenia());
            user.setIdRol(userDto.getIdRol());
            repo.save(user);
            return "Usuario actualizado correctamente";
        } else {
            return "Usuario no encontrado con ID: " + (id);
        }
    }

    public String delete(long id) {
        Optional<UserEntity> optional = repo.findById(id);
        if (optional.isPresent()) {
            repo.deleteById(id);
            return "Usuario eliminado correctamente";
        } else {
            return "Usuario no encontrado";
        }
    }

    public String post(DTOUser dtoUser) {
        try {
            UserEntity user = new UserEntity();
            user.setUsuario(dtoUser.getUsuario());
            user.setContrasenia(dtoUser.getContrasenia());
            user.setIdRol(dtoUser.getIdRol());

            repo.save(user);
            return "Usuario creado correctamente";
        } catch (Exception e) {
            return "Error al crear el usuario: " + e.getMessage();
        }
    }

    public String patchUser(Long id, DTOUser dto) {
        Optional<UserEntity> optional = repo.findById(id);
        if (optional.isPresent()) {
            UserEntity user = optional.get();

            if (dto.getUsuario() != null) {
                user.setUsuario(dto.getUsuario());
            }
            if (dto.getContrasenia() != null) {
                user.setContrasenia(dto.getContrasenia());
            }
            if (dto.getIdRol() != 0) {
                user.setIdRol(dto.getIdRol());
            }

            repo.save(user);
            return "Usuario actualizado parcialmente";
        }
        return "Usuario no encontrado";
    }
}


