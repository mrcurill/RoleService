package ru.sbrf.role_service.web.mapper;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import ru.sbrf.role_service.dao.entity.EComponent;
import ru.sbrf.role_service.dao.entity.UIConfig;
import ru.sbrf.role_service.web.response.UIConfigResponse;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-02-14T16:52:57+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@Component
public class ViewMapperImpl extends ViewMapper {

    @Override
    public UIConfigResponse viewToViewDto(UIConfig uiConfig) {
        if ( uiConfig == null ) {
            return null;
        }

        UIConfigResponse uIConfigResponse = new UIConfigResponse();

        uIConfigResponse.setName( uiConfig.getName() );
        uIConfigResponse.setDisabled( mapSetComponentToSetString( uiConfig.getDisabledEComponents() ) );
        uIConfigResponse.setOff( mapSetComponentToSetString( uiConfig.getOffEComponents() ) );
        uIConfigResponse.setOn( mapSetComponentToSetString( uiConfig.getOnEComponents() ) );

        return uIConfigResponse;
    }

    @Override
    protected Set<String> mapSetComponentToSetString(Set<EComponent> onEComponents) {
        if ( onEComponents == null ) {
            return null;
        }

        Set<String> set = new HashSet<String>( Math.max( (int) ( onEComponents.size() / .75f ) + 1, 16 ) );
        for ( EComponent eComponent : onEComponents ) {
            set.add( mapComponentToString( eComponent ) );
        }

        return set;
    }
}
