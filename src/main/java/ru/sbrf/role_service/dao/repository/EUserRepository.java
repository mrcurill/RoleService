package ru.sbrf.role_service.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sbrf.role_service.dao.entity.EUser;

import java.util.List;

@Repository
public interface EUserRepository extends CrudRepository<EUser, Long> {
    List<EUser> findAll();
    List<EUser> findByLogin(String login);
    List<EUser> findByLoginAndPassword(String login, String password);
}
