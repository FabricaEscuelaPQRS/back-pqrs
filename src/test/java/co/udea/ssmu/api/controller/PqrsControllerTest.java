package co.udea.ssmu.api.controller;

import co.udea.ssmu.api.model.dto.Pqrs;
import co.udea.ssmu.api.model.enums.*;
import co.udea.ssmu.api.service.pqrs.IPqrsService;
import co.udea.ssmu.api.service.pqrs.PqrsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class PqrsControllerTest {

    @Autowired
    private MockMvc mockMvc;  // Inyección de una instancia MockMvc para realizar pruebas HTTP

    @InjectMocks
    private PqrsController pqrsController;  // Inyección de la instancia del controlador que se probará

    @Mock
    private IPqrsService pqrsService;  // Creación de un mock para el servicio asociado que se inyectara dentro del controlador pqrs

    private Pqrs pqrsRequest;  // Declaración de un objeto Pqrs que se utilizará para configurar los datos de prueba

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);  // Inicialización de los mocks antes de cada prueba

        pqrsRequest = new Pqrs();  // Creación de un objeto Pqrs para configurar datos de prueba
        // Configuración de los datos de prueba
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date fechaCreacion = dateFormat.parse("2023-11-07T21:06:01.755Z");
        pqrsRequest.setTipoPqrs(PqrsTypes.Queja);
        pqrsRequest.setCreadoPor(3);
        pqrsRequest.setQuejaHacia(2);
        pqrsRequest.setCreadoPorRol("User");
        pqrsRequest.setEstadoPqrs(PqrsStates.Finalizado);
        pqrsRequest.setAdmin((long) 2);
        pqrsRequest.setEstadoAprobacion(Approved.Aprobado);
        pqrsRequest.setFechaCreacion(fechaCreacion);
        pqrsRequest.setDescripcionPqrs("string");
        pqrsRequest.setTipoQueja(ComplainType.ConduccionPeligrosa);
        pqrsRequest.setTipoReclamo(GrievanceType.SancionesInjustas);
    }

    @Test
    void createPqrs() throws Exception {
        // Configuración del comportamiento simulado del servicio
        Mockito.when(pqrsService.createPqrs(pqrsRequest)).thenReturn(pqrsRequest);

        // Llamada al controlador para crear la PQRS
        ResponseEntity<Pqrs> response = pqrsController.createPqrs(pqrsRequest);

        // Verificación de que la respuesta sea correcta
        Mockito.verify(pqrsService, Mockito.times(1)).createPqrs(pqrsRequest);
        // Verificación de que la respuesta HTTP sea HttpStatus.CREATED
        assert response.getStatusCode() == HttpStatus.CREATED;
        // Verificación de que el objeto PQRS devuelto sea el mismo que el objeto de solicitud
        assert response.getBody() == pqrsRequest;
    }

    @Test
    void deletePqrs() throws Exception {
        Integer pqrsId = 31;
        // Realización de una solicitud DELETE simulada a la ruta /pqrs/{id}
        mockMvc.perform(MockMvcRequestBuilders.delete("/pqrs/{id}", pqrsId)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void listPqrs() throws Exception {
        // Realización de una solicitud GET simulada a la ruta /pqrs
        mockMvc.perform(MockMvcRequestBuilders.get("/pqrs")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void getPqrsById() throws Exception {
        Integer pqrsId = 41;
        // Realización de una solicitud GET simulada a la ruta /pqrs/{id}
        mockMvc.perform(MockMvcRequestBuilders.get("/pqrs/{id}", pqrsId)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void updatePqrsState() throws Exception {
        Integer pqrsId = 41;
        PqrsStates pqrsState = PqrsStates.Finalizado;
        // Realización de una solicitud PUT simulada a la ruta /pqrs/{id}/{pqrsState}
        mockMvc.perform(MockMvcRequestBuilders.put("/pqrs/{id}/{pqrsState}", pqrsId, pqrsState.toString())
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void listPqrsByUser() throws Exception {
        Integer userId = 1;
        // Realización de una solicitud GET simulada a la ruta /pqrs/user/{id}
        mockMvc.perform(MockMvcRequestBuilders.get("/pqrs/user/{id}", userId)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void listPqrsByConductor() throws Exception {
        Integer driverId = 3;
        // Realización de una solicitud GET simulada a la ruta /pqrs/conductor/{id}
        mockMvc.perform(MockMvcRequestBuilders.get("/pqrs/conductor/{id}", driverId)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
}