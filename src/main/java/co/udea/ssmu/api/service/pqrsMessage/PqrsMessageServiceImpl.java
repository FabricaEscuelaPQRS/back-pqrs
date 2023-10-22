package co.udea.ssmu.api.service.pqrsMessage;

import co.udea.ssmu.api.model.dto.Archive;
import co.udea.ssmu.api.model.dto.PqrsMessage;
import co.udea.ssmu.api.model.entity.ArchiveE;
import co.udea.ssmu.api.model.entity.PqrsMessageE;
import co.udea.ssmu.api.model.mapper.PqrsMessageMapper;
import co.udea.ssmu.api.model.repository.PqrsMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PqrsMessageServiceImpl implements IPqrsMessageService {

    @Autowired
    PqrsMessageRepository pqrsMessageRepository;

    @Autowired
    PqrsMessageMapper pqrsMessageMapper;

    @Override
    public PqrsMessage createPqrsMessage(PqrsMessage pqrsMessage) {
        PqrsMessageE pqrsMessageE = pqrsMessageMapper.toEntity(pqrsMessage); // convertir el dto a entidad de base de datos

        pqrsMessageE = pqrsMessageRepository.save(pqrsMessageE); // guardar la entidad en la base de datos

        PqrsMessage pqrsMessageResponse = pqrsMessageMapper.toDto(pqrsMessageE); // convertir la entidad a dto

        return pqrsMessageResponse;
    }


    @Override
    public PqrsMessage deletePqrsMessage(Integer id) {
        Optional<PqrsMessageE> pqrsMessageEResult  = pqrsMessageRepository.findByMessageId(id);

        if( ! pqrsMessageEResult.isPresent() ) {
            return null;
        }

        PqrsMessageE pqrsMessageE = pqrsMessageEResult.get();
        pqrsMessageRepository.delete(pqrsMessageE);

        PqrsMessage pqrsMessageResponse = pqrsMessageMapper.toDto(pqrsMessageE); // convertir la entidad a dto

        return pqrsMessageResponse;
    }

    @Override
    public Iterable<PqrsMessageE> listPqrsMessage() {
        return pqrsMessageRepository.findAll();
    }

    @Override
    public PqrsMessage getPqrsMessageById(Integer id) {
        Optional<PqrsMessageE> pqrsMessageEResult  = pqrsMessageRepository.findByMessageId(id); // guardar la entidad en la base de datos

        if( ! pqrsMessageEResult.isPresent() ) {
            return null;
        }

        PqrsMessageE pqrsMessageE = pqrsMessageEResult.get();
        PqrsMessage pqrsMessageResponse = pqrsMessageMapper.toDto(pqrsMessageE); // convertir la entidad a dto

        return pqrsMessageResponse;
    }
}
