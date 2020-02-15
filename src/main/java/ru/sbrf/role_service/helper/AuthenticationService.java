package ru.sbrf.role_service.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sbrf.role_service.dao.repository.EUserRepository;


@Component
public class AuthenticationService {

    private EUserRepository eUserRepository;

    public AuthenticationService(EUserRepository eUserRepository) {
        this.eUserRepository = eUserRepository;
    }

    public Boolean checkLogin(String login, String password) {

        if( !eUserRepository.findByLoginAndPassword(login, password).isEmpty())
            return  true;
        else
            return false;
    }
}
