package ru.sbrf.role_service.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sbrf.role_service.dao.entity.ERole;

import java.util.List;

@Repository
public interface ERoleRepository extends CrudRepository<ERole, Long> {
    List<ERole> findAll ();
    List<ERole> findByName(String name);
}
