package co.udea.ssmu.api.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PqrsMensaje {
    private Long id;
    private String mensaje;
    private Long idPqrs;
    private String rolEscritor;
    private Long idEscritor;
    private Date fechaEscritura;
}