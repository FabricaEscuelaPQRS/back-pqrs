package co.udea.ssmu.api.controller;

import co.udea.ssmu.api.model.dto.Pqrs;
import co.udea.ssmu.api.model.entity.PqrsEntity;
import co.udea.ssmu.api.model.enums.*;
import co.udea.ssmu.api.service.pqrs.IPqrsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PqrsControllerTest {




    private PqrsController pqrsController;  // Inyección de la instancia del controlador que se probara

    @Mock
    private IPqrsService pqrsService;  // Creación de un mock para el servicio asociado que se inyectara dentro del controlador pqrs

    private Pqrs pqrsRequest;  // Declaración de un objeto Pqrs que se utilizará para configurar los datos de prueba


    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);  // Inicialización de los mocks antes de cada prueba
        pqrsController = new PqrsController(pqrsService);
        pqrsRequest = new Pqrs();  // Creación de un objeto Pqrs para configurar datos de prueba
        // Configuración de los datos de prueba
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date fechaCreacion = dateFormat.parse("2023-11-07T21:06:01.755Z");
        pqrsRequest.setId(1);
        pqrsRequest.setTipoPqrs(PqrsTypes.QUEJA);
        pqrsRequest.setCreadoPor(3);
        pqrsRequest.setQuejaHacia(2);
        pqrsRequest.setCreadoPorRol("User");
        pqrsRequest.setEstadoPqrs(PqrsStates.FINALIZADO);
        pqrsRequest.setAdmin((long) 2);
        pqrsRequest.setEstadoAprobacion(Approved.APROBADO);
        pqrsRequest.setFechaCreacion(fechaCreacion);
        pqrsRequest.setDescripcionPqrs("string");
        pqrsRequest.setTipoQueja(ComplainType.CONDUCCION_PELIGROSA);
        pqrsRequest.setTipoReclamo(GrievanceType.SANCIONES_INJUSTAS);
    }

    @Test
    void createPqrs() throws Exception {
        Mockito.when(pqrsService.createPqrs(pqrsRequest)).thenReturn(pqrsRequest);

        // Llama al método del controlador
        Pqrs pqrsCreated = pqrsController.createPqrs(pqrsRequest).getBody();

        // Verifica el resultado
        Assertions.assertEquals(pqrsRequest, pqrsCreated);
    }

    @Test
    void deletePqrs() throws Exception {
        int idTest=1;
        int idResult;

        Mockito.when(pqrsService.deletePqrs(idTest)).thenReturn(pqrsRequest);

        // Llama al método del controlador
        Pqrs pqrsDeleted = pqrsController.deletePqrs(idTest).getBody();

        idResult = pqrsDeleted.getId();

        // Verifica el resultado
        Assertions.assertEquals(pqrsRequest, pqrsDeleted);
        Assertions.assertEquals(idTest, idResult);
    }

    @Test
    void listPqrs() throws Exception {

        List<PqrsEntity> pqrs = Mockito.mock(List.class);

        Mockito.when(pqrsService.listPqrs()).thenReturn(pqrs);


        // Llama al método del controlador
        Iterable<PqrsEntity> getPqrs = pqrsController.listPqrs().getBody();

        // Verifica el resultado
        Assertions.assertEquals(pqrs, getPqrs);

    }

    @Test
    void getPqrsById() throws Exception {


        Mockito.when(pqrsService.getPqrsById(1)).thenReturn(pqrsRequest);

        // Llama al método del controlador
        Pqrs pqrsObtained = pqrsController.getPqrsById(1).getBody();

        // Verifica el resultado
        Assertions.assertEquals(pqrsRequest, pqrsObtained);

    }

    @Test
    void updatePqrsState() throws Exception {

        Mockito.when(pqrsService.updatePqrs("Pendiente",1)).thenReturn(pqrsRequest);

        // Llama al método del controlador
        Pqrs pqrsUpdated= pqrsController.updatePqrsState(1,"Pendiente").getBody();

        // Verifica el resultado
        Assertions.assertEquals(pqrsRequest, pqrsUpdated);



    }

    @Test
    void listPqrsByUser() throws Exception {
        Integer userId = 1;

        List<PqrsEntity> pqrs = Mockito.mock(List.class);

        Mockito.when(pqrsService.getPqrsByUsuario(userId)).thenReturn(pqrs);


        // Llama al método del controlador
        Iterable<PqrsEntity> getPqrs = pqrsController.listPqrsByUser(userId).getBody();

        // Verifica el resultado
        Assertions.assertEquals(pqrs, getPqrs);
    }

    @Test
    void listPqrsByConductor() throws Exception {
        Integer driverId = 1;

        List<PqrsEntity> pqrs = Mockito.mock(List.class);

        Mockito.when(pqrsService.getPqrsByConductor(driverId)).thenReturn(pqrs);


        // Llama al método del controlador
        Iterable<PqrsEntity> getPqrs = pqrsController.listPqrsByConductor(driverId).getBody();

        // Verifica el resultado
        Assertions.assertEquals(pqrs, getPqrs);
    }
}