package ru.sbrf.emoAuth.mapper;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import ru.sbrf.emoAuth.dto.ViewDto;
import ru.sbrf.emoAuth.entity.Component;
import ru.sbrf.emoAuth.entity.View;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-02-10T18:38:03+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@org.springframework.stereotype.Component
public class ViewMapperImpl extends ViewMapper {

    @Override
    public ViewDto viewToViewDto(View view) {
        if ( view == null ) {
            return null;
        }

        ViewDto viewDto = new ViewDto();

        viewDto.setName( view.getName() );
        viewDto.setDisabled( mapSetComponentToSetString( view.getDisabledComponents() ) );
        viewDto.setOff( mapSetComponentToSetString( view.getOffComponents() ) );
        viewDto.setOn( mapSetComponentToSetString( view.getOnComponents() ) );

        return viewDto;
    }

    @Override
    protected Set<String> mapSetComponentToSetString(Set<Component> onComponents) {
        if ( onComponents == null ) {
            return null;
        }

        Set<String> set = new HashSet<String>( Math.max( (int) ( onComponents.size() / .75f ) + 1, 16 ) );
        for ( Component component : onComponents ) {
            set.add( mapComponentToString( component ) );
        }

        return set;
    }
}
