package co.udea.ssmu.api.model.mapper;

import co.udea.ssmu.api.model.dto.User;
import co.udea.ssmu.api.model.entity.SsmuUserE;
import co.udea.ssmu.api.model.enums.UserRoles;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "userId", source = "id")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "stateUser", source = "state")
    @Mapping(target = "userRole", source = "userRole", qualifiedByName = "userRoleToUserRoleString")
    SsmuUserE toEntity(User user);

    @Mapping(target = "id", source = "userId")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "state", source = "stateUser")
    @Mapping(target = "userRole", source = "userRole", qualifiedByName = "userRoleStringToUserRole")
    User toDto(SsmuUserE ssmuUserE);

    @Named("userRoleToUserRoleString")
    default String userRoleToUserRoleString(UserRoles userRole) {
        return userRole.name();
    }

    @Named("userRoleStringToUserRole")
    default UserRoles userRoleStringToUserRole(String userRoleString) {
        return UserRoles.valueOf(userRoleString);
    }

    @Named("toEntityList")
    List<SsmuUserE> toEntityList(List<User> users);

    @Named("toDtoList")
    List<User> toDtoList(List<SsmuUserE> usersE);


}