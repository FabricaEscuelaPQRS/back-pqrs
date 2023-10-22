package co.udea.ssmu.api.model.mapper;


import co.udea.ssmu.api.model.dto.Archivo;
import co.udea.ssmu.api.model.entity.PqrsArchivoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ArchivoMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "urlArchivo", source = "url")
    @Mapping(target = "idMensaje", source = "idMensaje")
    PqrsArchivoEntity toEntity(Archivo archivo);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "url", source = "urlArchivo")
    @Mapping(target = "idMensaje", source = "idMensaje")
    Archivo toDto(PqrsArchivoEntity archiveE);
    @Named("toEntityList")
    List<PqrsArchivoEntity> toEntityList(List<Archivo> archivos);
    @Named("toDtoList")
    List<Archivo> toDtoList(List<PqrsArchivoEntity> archivesE);
}
