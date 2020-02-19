package ru.sbrf.role_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sbrf.role_service.dao.entity.EUser;
import ru.sbrf.role_service.dao.repository.EUserRepository;
import ru.sbrf.role_service.web.mapper.EUserMapper;
import ru.sbrf.role_service.web.response.EUserResponse;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EUserService {
    private EUserRepository eUserRepository;
    private EUserMapper eUserMapper;

    @Autowired
    public EUserService (EUserRepository eUserRepository,
                         EUserMapper eUserMapper) {
        this.eUserRepository = eUserRepository;
        this.eUserMapper = eUserMapper;
    }

    public EUser findByLogin(String login) {
        List<EUser> eUsers = eUserRepository.findByLogin(login);

        if( eUsers.isEmpty() )
            return null;

        return eUsers.get(0);
    }

    public Boolean findByLoginAndPassword(String login, String password) {
        if( eUserRepository.findByLoginAndPassword(login, password).isEmpty() )
            return false;

        return true;
    }

    public Set<EUserResponse> findAllEUserResponse() {
        Iterable<EUser> eUsers = eUserRepository.findAll();
        Set<EUserResponse> result = new HashSet<>();

        for( EUser eUser : eUsers )
            result.add(eUserMapper.eUserToEUserResponse(eUser));

        return result;
    }

    public EUserResponse findEUserResponseByLogin(String login) {
        EUser eUser = findByLogin(login);

        if( null == eUser )
            return null;

        return eUserMapper.eUserToEUserResponse(eUser);
    }




}
