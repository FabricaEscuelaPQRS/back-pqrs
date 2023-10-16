package co.udea.ssmu.api.model.mapper;

import co.udea.ssmu.api.model.dto.Pqrs;
import co.udea.ssmu.api.model.entity.PqrsE;
import co.udea.ssmu.api.model.enums.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PqrsMapper {
    @Mapping(target = "pqrsId", source = "id")
    @Mapping(target = "pqrsType", source = "pqrsType", qualifiedByName = "pqrsTypeToPqrsTypeString")
    @Mapping(target = "pqrsState", source = "pqrsState", qualifiedByName = "pqrsStateToPqrsStateString")
    @Mapping(target = "approved", source = "approved", qualifiedByName = "approvedToApprovedString")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "pqrsDescription", source = "pqrsDescription")
    @Mapping(target = "complaintType", source = "complainType", qualifiedByName = "complainTypeToComplainTypeString")
    @Mapping(target = "grievanceType", source = "grievanceType", qualifiedByName = "grievanceTypeToGrievanceTypeString")
    @Mapping(target = "createdBy", source = "createdBy")
    @Mapping(target = "adminId", source = "admin")
    @Mapping(target = "complainTo", source = "complainTo")
    PqrsE toEntity(Pqrs pqrs);

    @Mapping(target = "id", source = "pqrsId")
    @Mapping(target = "pqrsType", source = "pqrsType", qualifiedByName = "pqrsTypeStringToPqrsType")
    @Mapping(target = "pqrsState", source = "pqrsState", qualifiedByName = "pqrsStateStringToPqrsState")
    @Mapping(target = "approved", source = "approved", qualifiedByName = "approvedStringToApproved")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "pqrsDescription", source = "pqrsDescription")
    @Mapping(target = "complainType", source = "complaintType", qualifiedByName = "complainStringToComplainType")
    @Mapping(target = "grievanceType", source = "grievanceType", qualifiedByName = "grievanceStringToGrievanceType")
    @Mapping(target = "createdBy", source = "createdBy")
    @Mapping(target = "admin", source = "adminId")
    @Mapping(target = "complainTo", source = "complainTo")
    Pqrs toDto(PqrsE pqrsE);

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
            return ComplainType.MalComportamientoDelConductor;
        }
        if (complainString.equals("Estado del vehículo")) {
            return ComplainType.EstadoDelVehiculo;
        }
        if (complainString.equals("Cobro inadecuado")) {
            return ComplainType.CobroInadecuado;
        }
        if(complainString.equals("Conducción peligrosa")) {
            return ComplainType.ConduccionPeligrosa;
        }
        if(complainString.equals("Situaciones anómalas con pasajeros")) {
            return ComplainType.SituacionesAnomalasConPasajeros;
        }
        if(complainString.equals("Otros")) {
            return ComplainType.Otros;
        }
        return null;
    }

    @Named("grievanceStringToGrievanceType")
    default GrievanceType grievanceStringToGrievanceType(String grievanceString) {
        if (grievanceString == null) {
            return null;
        }
        if (grievanceString.equals("Sanciones Injustas")) {
            return GrievanceType.SancionesInjustas;
        }
        if (grievanceString.equals("Problemas de Facturación")) {
            return GrievanceType.ProblemasDeFacturacion;
        }
        if (grievanceString.equals("Otros")) {
            return GrievanceType.Otros;
        }
        return null;
    }


    @Named("toEntityList")
    List<PqrsE> toEntityList(List<Pqrs> pqrs);

    @Named("toDtoList")
    List<Pqrs> toDtoList(List<PqrsE> pqrsE);
}
