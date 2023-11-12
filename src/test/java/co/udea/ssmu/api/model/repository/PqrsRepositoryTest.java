package co.udea.ssmu.api.model.repository;

import co.udea.ssmu.api.model.dto.Pqrs;
import co.udea.ssmu.api.model.entity.PqrsEntity;
import co.udea.ssmu.api.model.enums.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class PqrsRepositoryTest {


    @Autowired
    PqrsRepository pqrsRepository;

    private PqrsEntity pqrsRequestEntity;


    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);  // Inicialización de los mocks antes de cada prueba

        pqrsRequestEntity = new PqrsEntity();  // Creación de un objeto Pqrs para configurar datos de prueba
        // Configuración de los datos de prueba
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date date = new Date();
        String formattedDate = dateFormat.format(date);
        Date parsedDate = dateFormat.parse(formattedDate);
        LocalDate localDate = parsedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        pqrsRequestEntity.setTipoPqrs(String.valueOf(PqrsTypes.Queja));
        pqrsRequestEntity.setCreadoPor(3);
        pqrsRequestEntity.setQuejaHacia(2);
        pqrsRequestEntity.setCreadoPorRol("User");
        pqrsRequestEntity.setEstadoPqrs(String.valueOf(PqrsStates.Finalizado));
        pqrsRequestEntity.setIdAdmin((long) 2);
        pqrsRequestEntity.setEstadoAprobacion(String.valueOf(Approved.Aprobado));
        pqrsRequestEntity.setFechaCreacion(localDate);
        pqrsRequestEntity.setDescripcionPqrs("string");
        pqrsRequestEntity.setTipoQueja(String.valueOf(ComplainType.ConduccionPeligrosa));
        pqrsRequestEntity.setTipoReclamo(String.valueOf(GrievanceType.SancionesInjustas));





    }


    @Test
    void findById() {

        pqrsRepository.save(pqrsRequestEntity);

        PqrsEntity pqrsObtained = pqrsRepository.findById(pqrsRequestEntity.getId()).get();

        Assertions.assertThat(pqrsObtained).isNotNull();

    }



    @Test
    void findAll() {

        pqrsRepository.save(pqrsRequestEntity);

        List<PqrsEntity> pqrsEntityList = pqrsRepository.findAll();

        Assertions.assertThat(pqrsEntityList).isNotNull();
        Assertions.assertThat(pqrsEntityList.size()).isEqualTo(1);

    }

    @Test
    void findByCreadoPor() {

        pqrsRepository.save(pqrsRequestEntity);

        ArrayList<PqrsEntity> pqrsObtained = pqrsRepository.findByCreadoPor(pqrsRequestEntity.getCreadoPor());

        Assertions.assertThat(pqrsObtained).isNotNull();
    }

    @Test
    void findByIdAdmin() {
        pqrsRepository.save(pqrsRequestEntity);

        ArrayList<PqrsEntity> pqrsObtained = pqrsRepository.findByCreadoPor(Math.toIntExact(pqrsRequestEntity.getIdAdmin()));

        Assertions.assertThat(pqrsObtained).isNotNull();

    }

    @Test
    void findAllByCreadoPorAndCreadoPorRol() {

        pqrsRepository.save(pqrsRequestEntity);

        ArrayList<PqrsEntity> pqrsObtained = pqrsRepository.findAllByCreadoPorAndCreadoPorRol(pqrsRequestEntity.getCreadoPor(),pqrsRequestEntity.getCreadoPorRol());

        Assertions.assertThat(pqrsObtained).isNotNull();

    }

    @Test
    void save() {
        //Act
        PqrsEntity savedPqrs = pqrsRepository.save(pqrsRequestEntity);

        //Assert
        Assertions.assertThat(savedPqrs).isNotNull();
        Assertions.assertThat(savedPqrs.getId()).isGreaterThan(0);

    }
}