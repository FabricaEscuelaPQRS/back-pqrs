package co.udea.ssmu.api.service.archive;

import co.udea.ssmu.api.model.dto.Archivo;
import co.udea.ssmu.api.model.dto.Pqrs;
import co.udea.ssmu.api.model.entity.PqrsArchivoEntity;
import co.udea.ssmu.api.model.entity.PqrsEntity;
import co.udea.ssmu.api.model.entity.PqrsMensajeEntity;
import co.udea.ssmu.api.model.mapper.ArchivoMapper;
import co.udea.ssmu.api.model.mapper.PqrsMapper;
import co.udea.ssmu.api.model.mapper.PqrsMensajeMapper;
import co.udea.ssmu.api.model.repository.ArchivoRepository;
import co.udea.ssmu.api.model.repository.PqrsMessageRepository;
import co.udea.ssmu.api.service.pqrsMessage.PqrsMessageServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class ArchiveServiceImplTest {



    @Mock
    private ArchivoRepository archivoRepository; // Repositorio para acceder a la base de datos


    @Spy
    ArchivoMapper archivoMapper= Mappers.getMapper(ArchivoMapper.class);

    @InjectMocks
    private ArchiveServiceImpl archiveService;



    private PqrsArchivoEntity pqrsArchivoEntity;


    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);  // Inicialización de los mocks antes de cada prueba

        pqrsArchivoEntity = new PqrsArchivoEntity();  
        // Configuración de los datos de prueba
        pqrsArchivoEntity.setId(1);
        pqrsArchivoEntity.setIdMensaje(1);
        pqrsArchivoEntity.setUrlArchivo("Prueba Mensaje");
    }




    @Test
    void createArchive() {


        when(archivoRepository.save(any(PqrsArchivoEntity.class))).thenReturn(pqrsArchivoEntity);

        Archivo savedArchive = archiveService.createArchive(archivoMapper.toDto(pqrsArchivoEntity));

        Assertions.assertThat(savedArchive).isNotNull();
    }


    @Test
    void listArchive() {

        List<PqrsArchivoEntity> pqrsArchivo = Mockito.mock(List.class);

        when(archivoRepository.findAll()).thenReturn(pqrsArchivo);

        Iterable<PqrsArchivoEntity> getPqrs = archiveService.listArchive();

        Assertions.assertThat(getPqrs).isNotNull();

    }



    @Test
    void getArchiveById() {
        when(archivoRepository.findById(pqrsArchivoEntity.getId())).thenReturn(Optional.ofNullable(pqrsArchivoEntity));

        Archivo archiveObtained = archiveService.getArchiveById(pqrsArchivoEntity.getId());

        Assertions.assertThat(archiveObtained).isNotNull();

    }



    @Test
    void deleteArchive() {

        when(archivoRepository.findById(pqrsArchivoEntity.getId())).thenReturn(Optional.ofNullable(pqrsArchivoEntity));
        doNothing().when(archivoRepository).delete(pqrsArchivoEntity);

        assertAll(() -> archiveService.deleteArchive(pqrsArchivoEntity.getId()));

    }
}