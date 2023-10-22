package co.udea.ssmu.api.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "PQRS")
public class PqrsEntity {
    @Id
    @Column(name = "ID_PQRS", nullable = false)
    @SequenceGenerator(name = "PQRS_ID_SEQ", sequenceName = "PQRS_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PQRS_ID_SEQ")
    private Integer id;

    @Size(max = 20)
    @NotNull
    @Column(name = "TIPO_PQRS", nullable = false, length = 20)
    private String tipoPqrs;

    @Column(name = "CREADO_POR")
    private Integer creadoPor;

    @Column(name = "QUEJA_HACIA")
    private Integer quejaHacia;

    @Size(max = 10)
    @Column(name = "CREADO_POR_ROL", length = 10)
    private String creadoPorRol;

    @Size(max = 10)
    @Column(name = "ESTADO_PQRS", length = 10)
    private String estadoPqrs;

    @Column(name = "ID_ADMIN")
    private Long idAdmin;

    @Size(max = 10)
    @Column(name = "ESTADO_APROBACION", length = 10)
    private String estadoAprobacion;

    @Column(name = "FECHA_CREACION")
    private LocalDate fechaCreacion;

    @Lob
    @Column(name = "DESCRIPCION_PQRS")
    private String descripcionPqrs;

    @Size(max = 50)
    @Column(name = "TIPO_QUEJA", length = 50)
    private String tipoQueja;

    @Size(max = 50)
    @Column(name = "TIPO_RECLAMO", length = 50)
    private String tipoReclamo;

}