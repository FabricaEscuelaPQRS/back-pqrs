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



    @Autowired
    ArchivoRepository archivoRepository;

    @Autowired
    ArchivoMapper archivoMapper;


    //Crear un archivo
    public Archivo createArchive(Archivo archivo) {

        PqrsArchivoEntity archiveE = archivoMapper.toEntity(archivo); // convertir el dto a entidad de base de datos

        archiveE = archivoRepository.save(archiveE); // guardar la entidad en la base de datos

        Archivo archivoResponse = archivoMapper.toDto(archiveE); // convertir la entidad a dto

        return archivoResponse;


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
        Archivo archivoResponse = archivoMapper.toDto(archiveE); // convertir la entidad a dto

        return archivoResponse;
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

        Archivo archivoResponse = archivoMapper.toDto(archiveE); // convertir la entidad a dto

        return archivoResponse;


    }




}
