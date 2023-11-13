package co.udea.ssmu.api.model.mapper;


import co.udea.ssmu.api.model.dto.Usuario;
import co.udea.ssmu.api.model.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {


    @Mapping(target = "id", source = "id")
    @Mapping(target = "idGrupo", source = "idGrupo")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "celular", source = "celular")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "cedula", source = "cedula")
    @Mapping(target = "rol", source = "rol")
    @Mapping(target = "idTipoUsuario", source = "idTipoUsuario")
    @Mapping(target = "nroServicios", source = "nroServicios")
    @Mapping(target = "habilitado", source = "habilitado")
    UsuarioEntity toEntity(Usuario usuario);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "idGrupo", source = "idGrupo")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "celular", source = "celular")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "cedula", source = "cedula")
    @Mapping(target = "rol", source = "rol")
    @Mapping(target = "idTipoUsuario", source = "idTipoUsuario")
    @Mapping(target = "nroServicios", source = "nroServicios")
    @Mapping(target = "habilitado", source = "habilitado")
    Usuario toDto(UsuarioEntity usuarioE);


}
