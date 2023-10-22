package co.udea.ssmu.api.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ADMINISTRADOR")
public class Administrador {
    @Id
    @Column(name = "ID_ADMINISTRADOR", nullable = false)
    private Long id;

    @Size(max = 50)
    @Column(name = "NOMBRE", length = 50)
    private String nombre;

    @Size(max = 50)
    @Column(name = "CELULAR", length = 50)
    private String celular;

    @Size(max = 50)
    @Column(name = "EMAIL", length = 50)
    private String email;

    @Size(max = 10)
    @Column(name = "CEDULA", length = 10)
    private String cedula;

    @Size(max = 10)
    @Column(name = "ROL", length = 10)
    private String rol;

    @Column(name = "ID_TIPO_ADMINISTRADOR")
    private Long idTipoAdministrador;

    @Size(max = 10)
    @Column(name = "NRO_SERVICIOS", length = 10)
    private String nroServicios;

}