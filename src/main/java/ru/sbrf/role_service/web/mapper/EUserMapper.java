package ru.sbrf.role_service.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.sbrf.role_service.dao.entity.EGroup;
import ru.sbrf.role_service.dao.entity.ERole;
import ru.sbrf.role_service.dao.entity.EUser;
import ru.sbrf.role_service.web.response.EUserResponse;

import java.util.Set;

@Mapper (componentModel = "spring")
public abstract class EUserMapper {
    @Mappings({
            @Mapping(source = "login", target = "login"),
            @Mapping(source = "createdAt", target = "createdAt"),
            @Mapping(source = "lastSign", target = "lastSign"),
            @Mapping(source = "isActive", target = "isActive"),
            @Mapping(source = "ip", target = "ip"),
//        @Mapping(source = "eRole", target = "role"),
//        @Mapping(source = "eGroups", target = "groups")
    })
    public abstract EUserResponse eUserToEUserResponse(EUser eUser);

    protected abstract Set<String> mapSetEGroupToSetString(Set<EGroup> eGroupSet);

    protected String mapEGroupToString(EGroup eGroup) {return eGroup.getName();}

    protected String mapERoleToString(ERole eRole) {return eRole.getName();}
}
