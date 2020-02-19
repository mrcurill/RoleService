package ru.sbrf.role_service.service;

import org.springframework.stereotype.Service;
import ru.sbrf.role_service.dao.entity.EComponent;
import ru.sbrf.role_service.dao.repository.EComponentRepository;
import ru.sbrf.role_service.web.mapper.EComponentMapper;

import java.util.List;

@Service
public class EComponentService {
    private EComponentRepository eComponentRepository;
    private EComponentMapper eComponentMapper;

    public EComponentService(EComponentRepository eComponentRepository,
                             EComponentMapper eComponentMapper) {
        this.eComponentRepository = eComponentRepository;
        this.eComponentMapper = eComponentMapper;
    }

    public List<EComponent> findAll () {
        return eComponentRepository.findAll();
    }

    public EComponent findByName (String name) {
        List<EComponent> eComponents = eComponentRepository.findByName(name);

        if(eComponents.isEmpty())
            return null;

        return  eComponents.get(0);
    }
}
