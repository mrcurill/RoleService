package ru.sbrf.role_service.service;

import org.springframework.stereotype.Service;
import ru.sbrf.role_service.dao.entity.UIConfig;
import ru.sbrf.role_service.dao.repository.UIConfigRepository;
import ru.sbrf.role_service.web.mapper.UIConfigMapper;
import ru.sbrf.role_service.web.response.UIConfigResponse;

import java.util.List;

@Service
public class UIConfigService {
    private UIConfigRepository uiConfigRepository;
    private UIConfigMapper uiConfigMapper;

    public UIConfigService( UIConfigRepository uiConfigRepository,
                            UIConfigMapper uiConfigMapper) {
        this.uiConfigRepository = uiConfigRepository;
        this.uiConfigMapper = uiConfigMapper;
    }

    public List<UIConfig> findAll() {
        return uiConfigRepository.findAll();
    }

    public UIConfig findByUId( String uid ) {
        List<UIConfig> uiConfigs = uiConfigRepository.findByUid(uid);

        if( uiConfigs.isEmpty() )
            return null;
        else
            return uiConfigs.get(0);
    }

    public UIConfigResponse findUIConfigResponseByUId( String uid ) {
        return uiConfigMapper.uiConfigToUIConfigResponse(findByUId(uid));
    }
}
