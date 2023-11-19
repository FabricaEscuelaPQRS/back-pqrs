package co.udea.ssmu.api.service.pqrsMessage;


import co.udea.ssmu.api.model.dto.PqrsMensaje;

import co.udea.ssmu.api.model.entity.PqrsMensajeEntity;

import co.udea.ssmu.api.model.mapper.PqrsMensajeMapper;
import co.udea.ssmu.api.model.repository.PqrsMessageRepository;

import co.udea.ssmu.api.service.pqrs.PqrsServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
@SpringBootTest
class PqrsMessageServiceImplTest {


    @Mock
    private PqrsMessageRepository pqrsMessageRepository; // Repositorio para acceder a la base de datos

    @Spy
    PqrsMensajeMapper pqrsMensajeMapper= Mappers.getMapper(PqrsMensajeMapper.class);


    private PqrsMessageServiceImpl pqrsMessageService;


    private PqrsMensajeEntity pqrsMensajeRequestEntity;


    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);  // Inicialización de los mocks antes de cada prueba
        pqrsMessageService = new PqrsMessageServiceImpl(pqrsMessageRepository,pqrsMensajeMapper);
        pqrsMensajeRequestEntity = new PqrsMensajeEntity();
        pqrsMensajeRequestEntity.setId(1);
        pqrsMensajeRequestEntity.setIdPqrs(1);
        pqrsMensajeRequestEntity.setMensaje("Prueba Mensaje");
    }





    @Test
    void createPqrsMessage() {

        when(pqrsMessageRepository.save(any(PqrsMensajeEntity.class))).thenReturn(pqrsMensajeRequestEntity);

        PqrsMensaje savedMessage= pqrsMessageService.createPqrsMessage(pqrsMensajeMapper.toDto(pqrsMensajeRequestEntity));

        Assertions.assertThat(savedMessage).isNotNull();

    }



    @Test
    void deletePqrsMessage() {

        when(pqrsMessageRepository.findById(pqrsMensajeRequestEntity.getId())).thenReturn(Optional.ofNullable(pqrsMensajeRequestEntity));
        doNothing().when(pqrsMessageRepository).delete(pqrsMensajeRequestEntity);

        assertAll(() -> pqrsMessageService.deletePqrsMessage(pqrsMensajeRequestEntity.getId()));


    }

    @Test
    void listPqrsMessage() {

        ArrayList<PqrsMensajeEntity> pqrsMensaje = Mockito.mock(ArrayList.class);

        when(pqrsMessageRepository.findAll()).thenReturn(pqrsMensaje);

        Iterable<PqrsMensajeEntity> getPqrsMensaje = pqrsMessageService.listPqrsMessage();

        Assertions.assertThat(getPqrsMensaje).isNotNull();

    }



    @Test
    void getPqrsMessageById() {
        int pqrsMessageId = 1;
        PqrsMensajeEntity pqrsMessage = new PqrsMensajeEntity();
        pqrsMessage.setId(1);


        when(pqrsMessageRepository.findById(pqrsMessageId)).thenReturn(Optional.ofNullable(pqrsMessage));

        PqrsMensaje pqrsObtained = pqrsMessageService.getPqrsMessageById(pqrsMessageId);

        Assertions.assertThat(pqrsObtained).isNotNull();

    }
}