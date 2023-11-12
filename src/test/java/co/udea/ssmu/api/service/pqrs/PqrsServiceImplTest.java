package co.udea.ssmu.api.service.pqrs;
import co.udea.ssmu.api.model.mapper.PqrsMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import co.udea.ssmu.api.model.dto.Pqrs;
import co.udea.ssmu.api.model.entity.PqrsEntity;
import co.udea.ssmu.api.model.enums.*;
import co.udea.ssmu.api.model.repository.PqrsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PqrsServiceImplTest {

    @Mock
    private PqrsRepository pqrsRepository; // Repositorio para acceder a la base de datos

    @Spy
    PqrsMapper pqrsMapper= Mappers.getMapper(PqrsMapper.class);


    @InjectMocks
    private PqrsServiceImpl pqrsService;


    private PqrsEntity pqrsRequestEntity;  // Declaración de un objeto Pqrs que se utilizará para configurar los datos de prueba



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

        pqrsRequestEntity.setId(1);
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
    void createPqrs()  {


        when(pqrsRepository.save(any(PqrsEntity.class))).thenReturn(pqrsRequestEntity);


        Pqrs savedPqrs = pqrsService.createPqrs(pqrsMapper.toDto(pqrsRequestEntity));

        Assertions.assertThat(savedPqrs).isNotNull();




    }



    @Test
    void deletePqrs() {

        when(pqrsRepository.findById(pqrsRequestEntity.getId())).thenReturn(Optional.ofNullable(pqrsRequestEntity));
        doNothing().when(pqrsRepository).delete(pqrsRequestEntity);

        assertAll(() -> pqrsService.deletePqrs(pqrsRequestEntity.getId()));

    }

    @Test
    void listPqrs() {

        List<PqrsEntity> pqrs = Mockito.mock(List.class);

        when(pqrsRepository.findAll()).thenReturn(pqrs);

        Iterable<PqrsEntity> getPqrs = pqrsService.listPqrs();

        Assertions.assertThat(getPqrs).isNotNull();

    }



    @Test
    void getPqrsById() {

        when(pqrsRepository.findById(pqrsRequestEntity.getId())).thenReturn(Optional.ofNullable(pqrsRequestEntity));

        Pqrs pqrsObtained = pqrsService.getPqrsById(pqrsRequestEntity.getId());

        Assertions.assertThat(pqrsObtained).isNotNull();

    }



    @Test
    void updatePqrs() {

        when(pqrsRepository.findById(pqrsRequestEntity.getId())).thenReturn(Optional.ofNullable(pqrsRequestEntity));
        when(pqrsRepository.save(pqrsRequestEntity)).thenReturn(pqrsRequestEntity);

        Pqrs updatePqrs = pqrsService.updatePqrs("Proceso", pqrsRequestEntity.getId());

        Assertions.assertThat(updatePqrs).isNotNull();


    }



    @Test
    void getPqrsByUsuario() {


        ArrayList<PqrsEntity> pqrsList = Mockito.mock(ArrayList.class);

        when(pqrsRepository.findAllByCreadoPorAndCreadoPorRol(1,"User")).thenReturn(pqrsList);

        Iterable<PqrsEntity> listObtained = pqrsService.getPqrsByUsuario(1);

        Assertions.assertThat(listObtained).isNotNull();

    }

    @Test
    void getPqrsByConductor() {

        ArrayList<PqrsEntity> pqrsList = Mockito.mock(ArrayList.class);

        when(pqrsRepository.findAllByCreadoPorAndCreadoPorRol(1,"Conductor")).thenReturn(pqrsList);

        Iterable<PqrsEntity> listObtained = pqrsService.getPqrsByConductor(1);

        Assertions.assertThat(listObtained).isNotNull();

    }
}