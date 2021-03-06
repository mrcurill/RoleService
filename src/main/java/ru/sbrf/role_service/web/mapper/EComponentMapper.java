package ru.sbrf.role_service.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.sbrf.role_service.dao.entity.EComponent;
import ru.sbrf.role_service.dao.entity.UIConfig;
import ru.sbrf.role_service.web.response.EComponentResponse;

import java.util.Set;

@Mapper (componentModel = "spring")
public abstract class EComponentMapper {
    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "onUIConfigs", target = "on"),
            @Mapping(source = "offUIConfigs", target = "off"),
            @Mapping(source = "disabledUIConfigs", target = "disabled")
    })
    public abstract EComponentResponse eComponentToEComponentResponse(EComponent eComponent);

    protected abstract Set<String> mapSetEComponentToSetString(Set<UIConfig> uiConfigs);

    protected String mapUIConfigToString(UIConfig uiConfig) {
        return uiConfig.getUid();
    }
}
