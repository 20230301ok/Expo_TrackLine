package apiTrackline.proyectoPTC.Models.DTO;

import apiTrackline.proyectoPTC.Entities.UserEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class DTOUser {
    private Long idUsuario;
    private String usuario;
    private String contrasenia;
    private Long idRol;
}


