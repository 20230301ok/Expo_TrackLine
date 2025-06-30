package apiTrackline.proyectoPTC.Entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "TB_USUARIOS")
@Getter @Setter @ToString @EqualsAndHashCode
public class UserEntity {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    //@SequenceGenerator(name = "seq_usuairo", sequenceName = "seq_usuario", allocationSize = 1)
    @Column(name = "IDUSUARIO")
    private long idUsuario;

    @Column(name = "USUARIO")
    private String usuario;

    @Column(name = "CONTRASENIA")
    private String contrasenia;

    @Column(name = "IDROL")
    private long idRol;
}
