package co.udea.ssmu.api.model.dto;


import lombok.Data;

@Data
public class Usuario {
    private Long id;
    private Long idGrupo;

    private String nombre;

    private String celular;

    private String email;

    private String cedula;

    private String rol;

    private Long idTipoUsuario;

    private String nroServicios;

    private Boolean habilitado;

}
