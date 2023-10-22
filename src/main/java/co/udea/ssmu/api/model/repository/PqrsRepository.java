package co.udea.ssmu.api.model.repository;


import co.udea.ssmu.api.model.entity.PqrsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface PqrsRepository extends CrudRepository<PqrsEntity, Integer> {
    Optional<PqrsEntity> findById(Integer id);
    ArrayList<PqrsEntity> findAll(); // buscar todas las pqrs
    ArrayList<PqrsEntity> findBycreatedBy(Integer createdBy); // buscar todas las pqrs por el id del creador

    ArrayList<PqrsEntity> findByAdminId(Integer adminId); // buscar todas las pqrs por el id del administrador

    PqrsEntity save(PqrsEntity pqrsE); // guardar una pqrs




}
