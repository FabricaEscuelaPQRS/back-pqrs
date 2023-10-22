package co.udea.ssmu.api.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "CONDUCTOR")
public class Conductor {



    @Id
    @Column(name = "ID_CONDUCTOR", nullable = false)
    private Long id;

    @Size(max = 50)
    @Column(name = "NOMBRE", length = 50)
    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Long getIdTipoConductor() {
        return idTipoConductor;
    }

    public void setIdTipoConductor(Long idTipoConductor) {
        this.idTipoConductor = idTipoConductor;
    }

    public String getNroServicios() {
        return nroServicios;
    }

    public void setNroServicios(String nroServicios) {
        this.nroServicios = nroServicios;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

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

    @Column(name = "ID_TIPO_CONDUCTOR")
    private Long idTipoConductor;

    @Size(max = 10)
    @Column(name = "NRO_SERVICIOS", length = 10)
    private String nroServicios;

    @Size(max = 10)
    @Column(name = "PLACA", length = 10)
    private String placa;

}