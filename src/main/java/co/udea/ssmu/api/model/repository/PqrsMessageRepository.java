package co.udea.ssmu.api.model.repository;

import co.udea.ssmu.api.model.entity.ArchiveE;
import co.udea.ssmu.api.model.entity.PqrsMessageE;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface PqrsMessageRepository extends CrudRepository<PqrsMessageE, Integer> {


        ArrayList<PqrsMessageE> findByPqrsId(Integer pqrsId); // buscar mensajes por el id de la pqrs

        Iterable<PqrsMessageE> findAll(); // buscar todos los mensajes

        PqrsMessageE save(PqrsMessageE pqrsMessageE); // guardar un mensaje

        Optional<PqrsMessageE> findByMessageId(Integer messageId); // buscar un mensaje por su id


}
