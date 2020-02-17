package ru.sbrf.role_service.web.mapper;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import ru.sbrf.role_service.dao.entity.EGroup;
import ru.sbrf.role_service.dao.entity.EUser;
import ru.sbrf.role_service.web.response.EUserResponse;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-02-17T12:58:42+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@Component
public class EUserMapperImpl extends EUserMapper {

    @Override
    public EUserResponse eUserToEUserResponse(EUser eUser) {
        if ( eUser == null ) {
            return null;
        }

        EUserResponse eUserResponse = new EUserResponse();

        eUserResponse.setCreatedAt( eUser.getCreatedAt() );
        eUserResponse.setLastSign( eUser.getLastSign() );
        eUserResponse.setRole( mapERoleToString( eUser.getERole() ) );
        eUserResponse.setIp( eUser.getIp() );
        eUserResponse.setGroups( mapSetEGroupToSetString( eUser.getEGroups() ) );
        eUserResponse.setLogin( eUser.getLogin() );
        eUserResponse.setIsActive( eUser.getIsActive() );

        return eUserResponse;
    }

    @Override
    protected Set<String> mapSetEGroupToSetString(Set<EGroup> eGroupSet) {
        if ( eGroupSet == null ) {
            return null;
        }

        Set<String> set = new HashSet<String>( Math.max( (int) ( eGroupSet.size() / .75f ) + 1, 16 ) );
        for ( EGroup eGroup : eGroupSet ) {
            set.add( mapEGroupToString( eGroup ) );
        }

        return set;
    }
}
