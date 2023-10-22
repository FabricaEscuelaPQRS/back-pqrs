package co.udea.ssmu.api.service.archive.facade;


import co.udea.ssmu.api.model.dto.Archivo;
import co.udea.ssmu.api.service.archive.service.ArchiveService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ArchiveFacade implements IArchiveFacade{

    @Autowired
    ArchiveService archiveService;

    @Override
    public Archivo createArchive(Archivo archivo) {
        return archiveService.createArchive(archivo);
    }

    @Override
    public Archivo deleteArchive(Long id) {
        return archiveService.deleteArchive(id);
    }

    @Override
    public Iterable<ArchiveE> listArchive() {
        return archiveService.listArchive();
    }

    @Override
    public Archivo getArchiveById(Long id) {
        return getArchiveById(id);
    }
}
