package ru.sbrf.emoAuth.mapper;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import ru.sbrf.emoAuth.dto.ComponentDto;
import ru.sbrf.emoAuth.entity.Component;
import ru.sbrf.emoAuth.entity.View;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-02-10T18:05:58+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@org.springframework.stereotype.Component
public class ComponentMapperImpl extends ComponentMapper {

    @Override
    public ComponentDto componentToComponentDto(Component component) {
        if ( component == null ) {
            return null;
        }

        ComponentDto componentDto = new ComponentDto();

        componentDto.setName( component.getName() );
        componentDto.setDisabled( mapSetComponentToSetString( component.getDisabledViews() ) );
        componentDto.setOff( mapSetComponentToSetString( component.getOffViews() ) );
        componentDto.setOn( mapSetComponentToSetString( component.getOnViews() ) );

        return componentDto;
    }

    @Override
    protected Set<String> mapSetComponentToSetString(Set<View> views) {
        if ( views == null ) {
            return null;
        }

        Set<String> set = new HashSet<String>( Math.max( (int) ( views.size() / .75f ) + 1, 16 ) );
        for ( View view : views ) {
            set.add( mapViewToString( view ) );
        }

        return set;
    }
}
