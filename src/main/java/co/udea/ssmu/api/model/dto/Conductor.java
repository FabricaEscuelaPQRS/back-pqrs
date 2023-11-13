package co.udea.ssmu.api.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Conductor {
    private Long id;

    private String nombre;

    private String celular;

    private String email;

    private String cedula;

    private String rol;

    private Long idTipoConductor;

    private String nroServicios;

    private String placa;

    private Boolean habilitado;

}
