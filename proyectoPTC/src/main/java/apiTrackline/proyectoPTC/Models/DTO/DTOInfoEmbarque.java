package apiTrackline.proyectoPTC.Models.DTO;

import jakarta.validation.constraints.Min;
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
    private Long idInfoEmbarque;

    private String facturas;
    private String proveedorRef;

    @Min(0)
    private Long bultos;

    private String tipo;

    @Min(0)
    private Double kilos;

    @Min(0)
    private Double volumen;
}
