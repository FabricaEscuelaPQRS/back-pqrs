package co.udea.ssmu.api.service.archive;

import co.udea.ssmu.api.model.dto.Archivo;

import co.udea.ssmu.api.model.entity.PqrsArchivoEntity;

public interface IArchiveService{
    public Archivo createArchive(Archivo archivo);
    public Archivo deleteArchive(Integer id);
    public Iterable<PqrsArchivoEntity> listArchive();
    public Archivo getArchiveById(Integer id);
}
