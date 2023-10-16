package co.udea.ssmu.api.model.repositories;

import co.udea.ssmu.api.model.entities.PqrsMessageE;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PqrsMessageRepository extends CrudRepository<PqrsMessageE, Integer> {

        PqrsMessageE findByMessageId(Integer messageId); // buscar un mensaje por su id
        ArrayList<PqrsMessageE> findByPqrsId(Integer pqrsId); // buscar mensajes por el id de la pqrs

        Iterable<PqrsMessageE> findAll(); // buscar todos los mensajes

        PqrsMessageE save(PqrsMessageE pqrsMessageE); // guardar un mensaje

}
