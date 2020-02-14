package ru.sbrf.role_service.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.sbrf.role_service.dao.entity.EComponent;
import ru.sbrf.role_service.dao.entity.UIConfig;
import ru.sbrf.role_service.web.response.UIConfigResponse;

import java.util.Set;

@Mapper (componentModel = "spring")
public abstract class ViewMapper {
    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "onEComponents", target = "on"),
            @Mapping(source = "offEComponents", target = "off"),
            @Mapping(source = "disabledEComponents", target = "disabled")
    })
    public abstract UIConfigResponse viewToViewDto(UIConfig uiConfig);

    protected abstract Set<String> mapSetComponentToSetString(Set<EComponent> onEComponents);

    protected String mapComponentToString(EComponent onEComponent) {
        return onEComponent.getName();
    }
}
