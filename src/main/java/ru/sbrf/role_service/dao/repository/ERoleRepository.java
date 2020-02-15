package ru.sbrf.role_service.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sbrf.role_service.dao.entity.ERole;

@Repository
public interface ERoleRepository extends CrudRepository<ERole, Long> {
}
