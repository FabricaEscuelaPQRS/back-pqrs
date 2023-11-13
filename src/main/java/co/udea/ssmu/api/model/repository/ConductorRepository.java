package co.udea.ssmu.api.model.repository;

import co.udea.ssmu.api.model.entity.ConductorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConductorRepository extends CrudRepository<ConductorEntity, Integer> {

}
