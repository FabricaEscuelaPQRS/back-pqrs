package co.udea.ssmu.api.model.repository;

import co.udea.ssmu.api.model.entity.Conductor;
import co.udea.ssmu.api.model.entity.PqrsMensajeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ConductorRepository extends CrudRepository<Conductor, Long> {

    ArrayList<Conductor> findAll();

}
