package ru.sbrf.role_service.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sbrf.role_service.dao.entity.UIConfig;

import java.util.List;

@Repository
public interface UIConfigRepository extends CrudRepository<UIConfig, Long> {
    List<UIConfig> findAll();
    List<UIConfig> findByUid(String uid);
}
