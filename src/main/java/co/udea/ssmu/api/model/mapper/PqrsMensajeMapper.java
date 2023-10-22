package co.udea.ssmu.api.model.mapper;

import co.udea.ssmu.api.model.dto.PqrsMensaje;
import co.udea.ssmu.api.model.entity.PqrsMensajeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PqrsMensajeMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "mensaje", source = "mensaje")
    @Mapping(target = "idPqrs", source = "idPqrs")
    PqrsMensajeEntity toEntity(PqrsMensaje pqrsMensaje);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "mensaje", source = "mensaje")
    @Mapping(target = "idPqrs", source = "idPqrs")
    PqrsMensaje toDto(PqrsMensajeEntity pqrsMessageE);

    @Named("toEntityList")
    List<PqrsMensajeEntity> toEntityList(List<PqrsMensaje> pqrsMensajes);

    @Named("toDtoList")
    List<PqrsMensaje> toDtoList(List<PqrsMensajeEntity> pqrsMessagesE);
}