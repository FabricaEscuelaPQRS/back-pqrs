package co.udea.ssmu.api.model.dto;

import lombok.Data;

@Data
public class PqrsMensaje {
    private Long id;
    private String mensaje;
    private Long idPqrs;
}