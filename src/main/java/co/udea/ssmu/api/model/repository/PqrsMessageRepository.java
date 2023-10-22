package co.udea.ssmu.api.model.repository;

import co.udea.ssmu.api.model.entity.PqrsMensajeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface PqrsMessageRepository extends CrudRepository<PqrsMensajeEntity, Integer> {

        Optional<PqrsMensajeEntity> findById(Integer id); // buscar un mensaje por su id
        ArrayList<PqrsMensajeEntity> findByIdPqrs(Integer idPqrs); // buscar mensajes por el id de la pqrs

        ArrayList<PqrsMensajeEntity> findAll(); // buscar todos los mensajes

        PqrsMensajeEntity save(PqrsMensajeEntity pqrsMessageE); // guardar un mensaje




}
