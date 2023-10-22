package co.udea.ssmu.api.service.archive;

import co.udea.ssmu.api.model.dto.Archive;
import co.udea.ssmu.api.model.entity.ArchiveE;
import co.udea.ssmu.api.model.mapper.ArchiveMapper;
import co.udea.ssmu.api.model.repository.ArchiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class ArchiveServiceImpl implements IArchiveService {



    @Autowired
    ArchiveRepository archiveRepository;

    @Autowired
    ArchiveMapper archiveMapper;


    public Archive createArchive(Archive archive) {

        ArchiveE archiveE = archiveMapper.toEntity(archive); // convertir el dto a entidad de base de datos

        archiveE = archiveRepository.save(archiveE); // guardar la entidad en la base de datos

        Archive archiveResponse = archiveMapper.toDto(archiveE); // convertir la entidad a dto

        return archiveResponse;


    }

    @Override
    public Iterable<ArchiveE> listArchive() {
        return archiveRepository.findAll();
    }

    @Override
    public Archive getArchiveById(Long id) {

        Optional<ArchiveE> archiveEResult  = archiveRepository.findByArchiveId(id);

        if( ! archiveEResult.isPresent() ) {
            return null;
        }

        ArchiveE archiveE = archiveEResult.get();
        Archive archiveResponse = archiveMapper.toDto(archiveE); // convertir la entidad a dto

        return archiveResponse;
    }

    @Override
    public Archive deleteArchive(Long id) {

        Optional<ArchiveE> archiveEResult  = archiveRepository.findByArchiveId(id);

        if( ! archiveEResult.isPresent() ) {
            return null;
        }

        ArchiveE archiveE = archiveEResult.get();
        archiveRepository.delete(archiveE);

        Archive archiveResponse = archiveMapper.toDto(archiveE); // convertir la entidad a dto

        return archiveResponse;


    }




}
