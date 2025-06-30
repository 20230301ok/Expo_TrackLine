package apiTrackline.proyectoPTC.Models.DTO;

import apiTrackline.proyectoPTC.Entities.UserEntity;
import lombok.ToString;

@ToString
public class UserDTO {
}

private UserDTO convertirUsuarioDTO(UserEntity usuario){
        UserDTO dto = new UserDTO();
        dto.setId(usuario.getId());
        dto.setId(usuario.getId());
        dto.setNombre (usuario.getNombre());
        dto.setApellido(usuario.getApellido());
        dto.setIdGrupoExpo(usuario.getIdGrupoExpo());
        dto.setIdRol(usuario.getIdRol());
        dto.setCorreo(usuario.getCorreo());
        dto.setContrasena(usuario.getContrasena());
        dto.setIdCargo (usuario.getIdCargo());
        return dto;
    }
}
