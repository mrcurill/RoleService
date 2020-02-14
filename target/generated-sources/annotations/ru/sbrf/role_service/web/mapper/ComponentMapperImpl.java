package ru.sbrf.role_service.web.mapper;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import ru.sbrf.role_service.dao.entity.EComponent;
import ru.sbrf.role_service.dao.entity.UIConfig;
import ru.sbrf.role_service.web.response.EComponentResponse;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-02-14T16:52:56+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@Component
public class ComponentMapperImpl extends ComponentMapper {

    @Override
    public EComponentResponse componentToComponentDto(EComponent eComponent) {
        if ( eComponent == null ) {
            return null;
        }

        EComponentResponse eComponentResponse = new EComponentResponse();

        eComponentResponse.setName( eComponent.getName() );
        eComponentResponse.setDisabled( mapSetComponentToSetString( eComponent.getDisabledUIConfigs() ) );
        eComponentResponse.setOff( mapSetComponentToSetString( eComponent.getOffUIConfigs() ) );
        eComponentResponse.setOn( mapSetComponentToSetString( eComponent.getOnUIConfigs() ) );

        return eComponentResponse;
    }

    @Override
    protected Set<String> mapSetComponentToSetString(Set<UIConfig> uiConfigs) {
        if ( uiConfigs == null ) {
            return null;
        }

        Set<String> set = new HashSet<String>( Math.max( (int) ( uiConfigs.size() / .75f ) + 1, 16 ) );
        for ( UIConfig uIConfig : uiConfigs ) {
            set.add( mapViewToString( uIConfig ) );
        }

        return set;
    }
}
