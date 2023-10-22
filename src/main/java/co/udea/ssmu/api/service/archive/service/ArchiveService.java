package co.udea.ssmu.api.service.archive.service;

import co.udea.ssmu.api.model.dto.Archivo;
import co.udea.ssmu.api.model.entity.ArchiveE;
import co.udea.ssmu.api.model.mapper.ArchivoMapper;
import co.udea.ssmu.api.model.repository.ArchivoRepository;
import co.udea.ssmu.api.service.archive.facade.IArchiveFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class ArchiveService implements IArchiveFacade{



    @Autowired
    ArchivoRepository archivoRepository;

    @Autowired
    ArchivoMapper archivoMapper;


    public Archivo createArchive(Archivo archivo) {

        ArchiveE archiveE = archivoMapper.toEntity(archivo); // convertir el dto a entidad de base de datos

        archiveE = archivoRepository.save(archiveE); // guardar la entidad en la base de datos

        Archivo archivoResponse = archivoMapper.toDto(archiveE); // convertir la entidad a dto

        return archivoResponse;


    }

    @Override
    public Iterable<ArchiveE> listArchive() {
        return archivoRepository.findAll();
    }

    @Override
    public Archivo getArchiveById(Long id) {

        Optional<ArchiveE> archiveEResult  = archivoRepository.findByArchiveId(id); // guardar la entidad en la base de datos

        if( ! archiveEResult.isPresent() ) {
            return null;
        }

        ArchiveE archiveE = archiveEResult.get();
        Archivo archivoResponse = archivoMapper.toDto(archiveE); // convertir la entidad a dto

        return archivoResponse;
    }

    @Override
    public Archivo deleteArchive(Long id) {

        Optional<ArchiveE> archiveEResult  = archivoRepository.findByArchiveId(id); // guardar la entidad en la base de datos

        if( ! archiveEResult.isPresent() ) {
            return null;
        }

        ArchiveE archiveE = archiveEResult.get();
        archivoRepository.delete(archiveE);

        Archivo archivoResponse = archivoMapper.toDto(archiveE); // convertir la entidad a dto

        return archivoResponse;


    }




}
