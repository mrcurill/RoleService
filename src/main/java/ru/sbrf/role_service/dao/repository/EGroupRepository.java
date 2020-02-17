package ru.sbrf.role_service.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sbrf.role_service.dao.entity.EGroup;

import java.util.List;

@Repository
public interface EGroupRepository extends CrudRepository<EGroup, Long> {
    List<EGroup> findAll();
    List<EGroup> findByName(String name);
}
