package co.udea.ssmu.api.service.archive.facade;

import co.udea.ssmu.api.model.dto.Archivo;
import co.udea.ssmu.api.model.entity.ArchiveE;

public interface IArchiveFacade {
    public Archivo createArchive(Archivo archivo);
    public Archivo deleteArchive(Long id);
    public Iterable<ArchiveE> listArchive();
    public Archivo getArchiveById(Long id);
}
