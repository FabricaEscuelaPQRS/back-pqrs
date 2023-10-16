package co.udea.ssmu.api.model.mapper;

import co.udea.ssmu.api.model.dto.PqrsMessage;
import co.udea.ssmu.api.model.entity.PqrsMessageE;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PqrsMessageMapper {
    @Mapping(target = "messageId", source = "id")
    @Mapping(target = "message", source = "message")
    @Mapping(target = "pqrsId", source = "pqrsId")
    PqrsMessageE toEntity(PqrsMessage pqrsMessage);

    @Mapping(target = "id", source = "messageId")
    @Mapping(target = "message", source = "message")
    @Mapping(target = "pqrsId", source = "pqrsId")
    PqrsMessage toDto(PqrsMessageE pqrsMessageE);

    @Named("toEntityList")
    List<PqrsMessageE> toEntityList(List<PqrsMessage> pqrsMessages);

    @Named("toDtoList")
    List<PqrsMessage> toDtoList(List<PqrsMessageE> pqrsMessagesE);
}