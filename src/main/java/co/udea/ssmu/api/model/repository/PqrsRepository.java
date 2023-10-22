package co.udea.ssmu.api.model.repository;


import co.udea.ssmu.api.model.entity.PqrsE;
import co.udea.ssmu.api.model.entity.PqrsMessageE;
import co.udea.ssmu.api.model.enums.PqrsStates;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface PqrsRepository extends CrudRepository<PqrsE, Integer> {

    Optional<PqrsE> findByPqrsId(Integer messageId); // buscar una pqrs por su id


    //modificar para agregar buscar para un usuario y para un admin
    ArrayList<PqrsE> findAll(); // buscar todas las pqrs
    ArrayList<PqrsE> findBycreatedBy(Integer createdBy); // buscar todas las pqrs por el id del creador

    ArrayList<PqrsE> findByAdminId(Integer adminId); // buscar todas las pqrs por el id del administrador

    PqrsE save(PqrsE pqrsE); // guardar una pqrs


    @Modifying
    @Query("update PqrsE p set p.pqrsState  = ?1 where p.pqrsId = ?2")
    PqrsE updateStateByPqrsId(String pqrsState, Integer pqrsId);




}
