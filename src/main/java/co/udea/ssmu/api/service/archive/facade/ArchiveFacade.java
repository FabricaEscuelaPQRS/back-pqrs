package co.udea.ssmu.api.service.archive.facade;


import co.udea.ssmu.api.model.dto.Archive;
import co.udea.ssmu.api.model.entity.ArchiveE;
import co.udea.ssmu.api.service.archive.service.ArchiveService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.udea.ssmu.api.model.mapper.ArchiveMapper;

import java.util.Optional;

@Service
@Transactional
public class ArchiveFacade implements IArchiveFacade{

    @Autowired
    ArchiveService archiveService;

    @Override
    public Archive createArchive(Archive archive) {
        return archiveService.createArchive(archive);
    }

    @Override
    public Archive deleteArchive(Long id) {
        return archiveService.deleteArchive(id);
    }

    @Override
    public Iterable<ArchiveE> listArchive() {
        return archiveService.listArchive();
    }

    @Override
    public Archive getArchiveById(Long id) {
        return getArchiveById(id);
    }
}
