package co.udea.ssmu.api.service.archive;


import co.udea.ssmu.api.model.dto.Archivo;
import co.udea.ssmu.api.model.entity.PqrsArchivoEntity;
import co.udea.ssmu.api.model.mapper.ArchivoMapper;
import co.udea.ssmu.api.model.repository.ArchivoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class ArchiveServiceImpl implements IArchiveService {





    private final ArchivoMapper archivoMapper;
    private final ArchivoRepository archivoRepository;


    // Constructor for constructor injection
    @Autowired
    public ArchiveServiceImpl(ArchivoMapper archivoMapper, ArchivoRepository archivoRepository) {
        this.archivoMapper = archivoMapper;
        this.archivoRepository = archivoRepository;
    }



    //Crear un archivo
    public Archivo createArchive(Archivo archivo) {

        PqrsArchivoEntity archiveE = archivoMapper.toEntity(archivo); // convertir el dto a entidad de base de datos

        archiveE = archivoRepository.save(archiveE); // guardar la entidad en la base de datos



        return archivoMapper.toDto(archiveE);


    }


    //Obtener todos los archivos
    @Override
    public Iterable<PqrsArchivoEntity> listArchive() {
        return archivoRepository.findAll();
    }


    //Obtener archivo dado un id
    @Override
    public Archivo getArchiveById(Integer id) {

        Optional<PqrsArchivoEntity> archiveEResult  = archivoRepository.findById(id);

        if( ! archiveEResult.isPresent() ) {
            return null;
        }

        PqrsArchivoEntity archiveE = archiveEResult.get();

        return archivoMapper.toDto(archiveE);
    }


    //Eliminar archivo
    @Override
    public Archivo deleteArchive(Integer id) {

        Optional<PqrsArchivoEntity> archiveEResult  = archivoRepository.findById(id);

        if( ! archiveEResult.isPresent() ) {
            return null;
        }

        PqrsArchivoEntity archiveE = archiveEResult.get();
        archivoRepository.delete(archiveE);



        return archivoMapper.toDto(archiveE);


    }




}
