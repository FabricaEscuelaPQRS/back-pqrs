package co.udea.ssmu.api.model.mapper;

import co.udea.ssmu.api.model.dto.Conductor;
import co.udea.ssmu.api.model.entity.ConductorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ConductorMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "celular", source = "celular")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "cedula", source = "cedula")
    @Mapping(target = "rol", source = "rol")
    @Mapping(target = "idTipoConductor", source = "idTipoConductor")
    @Mapping(target = "nroServicios", source = "nroServicios")
    @Mapping(target = "placa", source = "placa")
    @Mapping(target = "habilitado", source = "habilitado")
    ConductorEntity toEntity(Conductor conductor);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "celular", source = "celular")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "cedula", source = "cedula")
    @Mapping(target = "rol", source = "rol")
    @Mapping(target = "idTipoConductor", source = "idTipoConductor")
    @Mapping(target = "nroServicios", source = "nroServicios")
    @Mapping(target = "placa", source = "placa")
    @Mapping(target = "habilitado", source = "habilitado")
    Conductor toDto(ConductorEntity conductorE);

}
