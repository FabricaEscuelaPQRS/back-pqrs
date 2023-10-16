package co.udea.ssmu.api.model.repositories;


import co.udea.ssmu.api.model.entities.ArchiveE;
import co.udea.ssmu.api.model.entities.PqrsE;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Repository
public interface PqrsRepository extends CrudRepository<PqrsE, Integer> {

    PqrsE findByPqrsId(Integer pqrsId); // buscar una pqrs por su id

    ArrayList<PqrsE> findAll(); // buscar todas las pqrs
    ArrayList<PqrsE> findBycreatedBy(Integer createdBy); // buscar todas las pqrs por el id del creador

    ArrayList<PqrsE> findByAdminId(Integer adminId); // buscar todas las pqrs por el id del administrador

    PqrsE save(PqrsE pqrsE); // guardar una pqrs




}
