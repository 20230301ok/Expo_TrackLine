package apiTrackline.proyectoPTC.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "TB_INFOEMBARQUE")
@Getter @Setter @ToString @EqualsAndHashCode
public class InfoEmbarqueEntity {

    @Id
    @Column(name = "IDINFOEMBARQUE")
    private long idInfoEmbarque;

    @Column(name = "FACTURAS")
    private String facturas;

    @Column(name = "PROVEEDORREF")
    private String proveedorRef;

    @Column(name = "BULTOS")
    private long bultos;

    @Column(name = "TIPO")
    private String tipo;

    @Column(name = "KILOS")
    private long kilos;

    @Column(name = "VOLUMEN")
    private long volumen;
}
