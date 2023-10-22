package co.udea.ssmu.api.model.repository;

import co.udea.ssmu.api.model.entity.ArchiveE;
import co.udea.ssmu.api.model.entity.PqrsE;
import co.udea.ssmu.api.model.entity.PqrsMessageE;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArchiveRepository extends CrudRepository<ArchiveE, Integer> {

    Optional<ArchiveE> findByArchiveId(Long archiveId);


}
