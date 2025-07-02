package apiTrackline.proyectoPTC.Models.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class DTOInfoEmbarque {

    @NotBlank(message = "El id del info embarque es obligatorio")
    private long idInfoEmbarque;

    private String facturas;
    private String proveedorRef;
    private long bultos;
    private String tipo;
    private long kilos;
    private long volumen;
}
