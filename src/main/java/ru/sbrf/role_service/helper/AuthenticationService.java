package ru.sbrf.role_service.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sbrf.role_service.dao.repository.EUserRepository;


@Component
public class AuthenticationService {

    @Autowired
    private EUserRepository EUserRepository;

    public Boolean checkLogin(String login, String password) {

        if( !EUserRepository.findByLoginAndPassword(login, password).isEmpty())
            return  true;
        else
            return false;
    }
}
