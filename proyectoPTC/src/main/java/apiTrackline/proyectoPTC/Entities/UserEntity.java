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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_US")
    @SequenceGenerator(name = "seq_id_US", sequenceName = "seq_id_US", allocationSize = 0)
    @Column(name = "IDUSUARIO")
    private Long idUsuario;

    @Column(name = "USUARIO")
    private String usuario;

    @Column(name = "CONTRASENIA")
    private String contrasenia;

    @Column(name = "IDROL")
    private Long idRol;
}
