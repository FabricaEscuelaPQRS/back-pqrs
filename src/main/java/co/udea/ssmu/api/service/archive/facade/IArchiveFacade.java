package co.udea.ssmu.api.service.archive.facade;

import co.udea.ssmu.api.model.dto.Archive;
import co.udea.ssmu.api.model.entity.ArchiveE;

import java.util.Optional;

public interface IArchiveFacade {

    public Archive createArchive(Archive archive);
    public Archive deleteArchive(Long id);
    public Iterable<ArchiveE> listArchive();
    public Archive getArchiveById(Long id);

}
