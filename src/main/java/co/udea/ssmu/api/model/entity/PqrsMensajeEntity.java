package co.udea.ssmu.api.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "PQRS_MENSAJE")
public class PqrsMensajeEntity {
    @Id
    @Column(name = "ID_MENSAJE", nullable = false)
    @SequenceGenerator(name = "PQRS_MESSAGE_ID_SEQ", sequenceName = "PQRS_MESSAGE_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PQRS_MESSAGE_ID_SEQ")
    private Integer id;

    @Column(name = "ID_PQRS")
    private Integer idPqrs;

    @Column(name = "ROL_ESCRITOR")
    private String rolEscritor;

    @Column(name = "ID_ESCRITOR")
    private Integer idEscritor;

    @Column(name = "FECHA_ESCRITURA")
    private LocalDate fechaEscritura;

    @Lob
    @Column(name = "MENSAJE")
    private String mensaje;

}