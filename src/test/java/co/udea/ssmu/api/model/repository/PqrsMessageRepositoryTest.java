package co.udea.ssmu.api.model.repository;

import co.udea.ssmu.api.model.dto.PqrsMensaje;
import co.udea.ssmu.api.model.entity.PqrsEntity;
import co.udea.ssmu.api.model.entity.PqrsMensajeEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class PqrsMessageRepositoryTest {

    @Autowired
    private PqrsMessageRepository pqrsMessageRepository; //Inyeccion del repositorio

    private PqrsMensajeEntity pqrsMensajeRequestEntity;


    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);  // Inicialización de los mocks antes de cada prueba

        pqrsMensajeRequestEntity = new PqrsMensajeEntity();
        pqrsMensajeRequestEntity.setIdPqrs(1);
        pqrsMensajeRequestEntity.setMensaje("Prueba Mensaje");
    }

    @Test
    void findById() {

        pqrsMessageRepository.save(pqrsMensajeRequestEntity);

        PqrsMensajeEntity pqrsMessageObtained = pqrsMessageRepository.findById(pqrsMensajeRequestEntity.getId()).get();

        Assertions.assertThat(pqrsMessageObtained).isNotNull();

    }

    @Test
    void findByIdPqrs() {

        pqrsMessageRepository.save(pqrsMensajeRequestEntity);

        ArrayList<PqrsMensajeEntity> pqrsMessageObtained = pqrsMessageRepository.findByIdPqrs(pqrsMensajeRequestEntity.getIdPqrs());

        Assertions.assertThat(pqrsMessageObtained).isNotNull();

    }

    @Test
    void findAll() {

        pqrsMessageRepository.save(pqrsMensajeRequestEntity);

        ArrayList<PqrsMensajeEntity> pqrsMessageEntityList = pqrsMessageRepository.findAll();

        Assertions.assertThat(pqrsMessageEntityList).isNotNull();
        Assertions.assertThat(pqrsMessageEntityList.size()).isEqualTo(1);

    }

    @Test
    void save() {

        //Act
        PqrsMensajeEntity savedPqrsMessage = pqrsMessageRepository.save(pqrsMensajeRequestEntity);

        //Assert
        Assertions.assertThat(savedPqrsMessage).isNotNull();
        Assertions.assertThat(savedPqrsMessage.getId()).isGreaterThan(0);

    }
}