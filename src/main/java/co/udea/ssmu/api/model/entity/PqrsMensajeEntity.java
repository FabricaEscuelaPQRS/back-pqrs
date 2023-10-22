package co.udea.ssmu.api.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @Lob
    @Column(name = "MENSAJE")
    private String mensaje;

}