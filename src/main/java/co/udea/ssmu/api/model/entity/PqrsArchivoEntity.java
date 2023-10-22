package co.udea.ssmu.api.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PQRS_ARCHIVO")
public class PqrsArchivoEntity {
    @Id
    @Column(name = "ID_ARCHIVO", nullable = false)
    @SequenceGenerator(name = "ARCHIVE_A_ID_SEQ", sequenceName = "ARCHIVE_A_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ARCHIVE_A_ID_SEQ")
    private Integer id;

    @Column(name = "ID_MENSAJE")
    private Integer idMensaje;

    @Size(max = 255)
    @Column(name = "URL_ARCHIVO")
    private String urlArchivo;

}