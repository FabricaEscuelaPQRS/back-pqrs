package co.udea.ssmu.api.model.repository;


import co.udea.ssmu.api.model.entity.PqrsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface PqrsRepository extends CrudRepository<PqrsEntity, Integer> {
    Optional<PqrsEntity> findById(Integer id);
    ArrayList<PqrsEntity> findAll(); // buscar todas las pqrs
    ArrayList<PqrsEntity> findByCreadoPor(Integer creadoPor); // buscar todas las pqrs por el id del creador

    ArrayList<PqrsEntity> findByIdAdmin(Integer idAdmin); // buscar todas las pqrs por el id del administrador

    PqrsEntity save(PqrsEntity pqrsEntity); // guardar una pqrs


    @Modifying
    @Query("update PqrsEntity p set p.estadoPqrs  = ?1 where p.id = ?2")
    PqrsEntity updateStateByPqrsId(String pqrsState, Integer pqrsId);




}
