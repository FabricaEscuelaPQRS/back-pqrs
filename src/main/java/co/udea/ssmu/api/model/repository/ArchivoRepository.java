package co.udea.ssmu.api.model.repository;


import co.udea.ssmu.api.model.entity.PqrsArchivoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArchivoRepository extends CrudRepository<PqrsArchivoEntity, Integer> {
    Optional<PqrsArchivoEntity> findById(Integer id);
}
