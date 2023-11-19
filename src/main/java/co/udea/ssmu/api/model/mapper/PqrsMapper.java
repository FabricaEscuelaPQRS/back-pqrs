package co.udea.ssmu.api.model.mapper;

import co.udea.ssmu.api.model.dto.Pqrs;

import co.udea.ssmu.api.model.entity.PqrsEntity;
import co.udea.ssmu.api.model.enums.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PqrsMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "tipoPqrs", source = "tipoPqrs", qualifiedByName = "pqrsTypeToPqrsTypeString")
    @Mapping(target = "estadoPqrs", source = "estadoPqrs", qualifiedByName = "pqrsStateToPqrsStateString")
    @Mapping(target = "estadoAprobacion", source = "estadoAprobacion", qualifiedByName = "approvedToApprovedString")
    @Mapping(target = "fechaCreacion", source = "fechaCreacion")
    @Mapping(target = "descripcionPqrs", source = "descripcionPqrs")
    @Mapping(target = "tipoQueja", source = "tipoQueja", qualifiedByName = "complainTypeToComplainTypeString")
    @Mapping(target = "tipoReclamo", source = "tipoReclamo", qualifiedByName = "grievanceTypeToGrievanceTypeString")
    @Mapping(target = "creadoPor", source = "creadoPor")
    @Mapping(target = "creadoPorRol", source = "creadoPorRol")
    @Mapping(target = "idAdmin", source = "admin")
    @Mapping(target = "quejaHacia", source = "quejaHacia")
    PqrsEntity toEntity(Pqrs pqrs);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "tipoPqrs", source = "tipoPqrs", qualifiedByName = "pqrsTypeStringToPqrsType")
    @Mapping(target = "estadoPqrs", source = "estadoPqrs", qualifiedByName = "pqrsStateStringToPqrsState")
    @Mapping(target = "estadoAprobacion", source = "estadoAprobacion", qualifiedByName = "approvedStringToApproved")
    @Mapping(target = "fechaCreacion", source = "fechaCreacion")
    @Mapping(target = "descripcionPqrs", source = "descripcionPqrs")
    @Mapping(target = "tipoQueja", source = "tipoQueja", qualifiedByName = "complainStringToComplainType")
    @Mapping(target = "tipoReclamo", source = "tipoReclamo", qualifiedByName = "grievanceStringToGrievanceType")
    @Mapping(target = "creadoPor", source = "creadoPor")
    @Mapping(target = "creadoPorRol", source = "creadoPorRol")
    @Mapping(target = "admin", source = "idAdmin")
    @Mapping(target = "quejaHacia", source = "quejaHacia")
    Pqrs toDto(PqrsEntity pqrsEntity);

    @Named("pqrsTypeToPqrsTypeString")
    default String pqrsTypeToPqrsTypeString(PqrsTypes pqrsType) {
        return pqrsType.name();
    }

    @Named("pqrsStateToPqrsStateString")
    default String pqrsStateToPqrsStateString(PqrsStates pqrsState) {
        return pqrsState.name();
    }

    @Named("approvedToApprovedString")
    default String approvedToApprovedString(Approved approved) {
        return approved.name();
    }

    @Named("complainTypeToComplainTypeString")
    default String complainTypeToComplainTypeString(ComplainType complainType) {
        if(complainType == null) {
            return null;
        }
        return complainType.description;
    }

    @Named("grievanceTypeToGrievanceTypeString")
    default String grievanceTypeToGrievanceTypeString(GrievanceType grievanceType) {
        if(grievanceType == null) {
            return null;
        }
        return grievanceType.description;
    }

    @Named("pqrsTypeStringToPqrsType")
    default PqrsTypes pqrsTypeStringToPqrsType(String pqrsTypeString) {
        return PqrsTypes.valueOf(pqrsTypeString);
    }

    @Named("pqrsStateStringToPqrsState")
    default PqrsStates pqrsStateStringToPqrsState(String pqrsStateString) {
        return PqrsStates.valueOf(pqrsStateString);
    }

    @Named("approvedStringToApproved")
    default Approved approvedStringToApproved(String approvedString) {
        return Approved.valueOf(approvedString);
    }

    @Named("complainStringToComplainType")
    default ComplainType complainStringToComplainType(String complainString) {
        if (complainString == null) {
            return null;
        }
        if (complainString.equals("Mal comportamiento del conductor")) {
            return ComplainType.MAL_COMPORTAMIENTO_DEL_CONDUCTOR;
        }
        if (complainString.equals("Estado del vehiculo")) {
            return ComplainType.ESTADO_DEL_VEHICULO;
        }
        if (complainString.equals("Cobro inadecuado")) {
            return ComplainType.COBRO_INADECUADO;
        }
        if(complainString.equals("Conduccion peligrosa")) {
            return ComplainType.CONDUCCION_PELIGROSA;
        }
        if(complainString.equals("Situaciones anomalas con pasajeros")) {
            return ComplainType.SITUACIONES_ANOMALAS_CON_PASAJEROS;
        }
        if(complainString.equals("Otros")) {
            return ComplainType.OTROS;
        }
        return null;
    }

    @Named("grievanceStringToGrievanceType")
    default GrievanceType grievanceStringToGrievanceType(String grievanceString) {
        if (grievanceString == null) {
            return null;
        }
        if (grievanceString.equals("Sanciones Injustas")) {
            return GrievanceType.SANCIONES_INJUSTAS;
        }
        if (grievanceString.equals("Problemas de Facturacion")) {
            return GrievanceType.PROBLEMAS_DE_FACTURACION;
        }
        if (grievanceString.equals("Otros")) {
            return GrievanceType.OTROS;
        }
        return null;
    }


    @Named("toEntityList")
    List<PqrsEntity> toEntityList(List<Pqrs> pqrs);

    @Named("toDtoList")
    List<Pqrs> toDtoList(List<PqrsEntity> pqrsEntity);
}
