package co.udea.ssmu.api.model.mapper;


import co.udea.ssmu.api.model.dto.Archive;
import co.udea.ssmu.api.model.entity.ArchiveE;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ArchiveMapper {
    @Mapping(target = "archiveId", source = "id")
    @Mapping(target = "urlA", source = "url")
    @Mapping(target = "messageId", source = "messageId")
    ArchiveE toEntity(Archive archive);
    @Mapping(target = "id", source = "archiveId")
    @Mapping(target = "url", source = "urlA")
    @Mapping(target = "messageId", source = "messageId")
    Archive toDto(ArchiveE archiveE);
    @Named("toEntityList")
    List<ArchiveE> toEntityList(List<Archive> archives);
    @Named("toDtoList")
    List<Archive> toDtoList(List<ArchiveE> archivesE);
}
