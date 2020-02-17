package ru.sbrf.role_service.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sbrf.role_service.dao.entity.EComponent;

import java.util.List;

@Repository
public interface EComponentRepository extends CrudRepository<EComponent, Long> {
    List<EComponent> findAll();
    List<EComponent> findByName(String name);
}
