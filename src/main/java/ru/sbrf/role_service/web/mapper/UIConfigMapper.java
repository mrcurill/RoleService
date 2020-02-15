package ru.sbrf.role_service.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.sbrf.role_service.dao.entity.EComponent;
import ru.sbrf.role_service.dao.entity.UIConfig;
import ru.sbrf.role_service.web.response.UIConfigResponse;

import java.util.Set;

@Mapper (componentModel = "spring")
public abstract class UIConfigMapper {
    @Mappings({
            @Mapping(source = "uid", target = "name"),
            @Mapping(source = "onEComponents", target = "on"),
            @Mapping(source = "offEComponents", target = "off"),
            @Mapping(source = "disabledEComponents", target = "disabled")
    })
    public abstract UIConfigResponse uiConfigToUIConfigResponse(UIConfig uiConfig);

    protected abstract Set<String> mapSetEComponentToSetString(Set<EComponent> onEComponents);

    protected String mapEComponentToString(EComponent eComponent) {
        return eComponent.getName();
    }
}
