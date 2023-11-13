package co.udea.ssmu.api.model.repository;

import co.udea.ssmu.api.model.entity.PqrsEntity;
import co.udea.ssmu.api.model.entity.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UsuarioEntity, Integer> {

}
