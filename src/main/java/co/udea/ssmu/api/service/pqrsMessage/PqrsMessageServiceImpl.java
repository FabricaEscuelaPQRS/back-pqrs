package co.udea.ssmu.api.service.pqrsMessage;


import co.udea.ssmu.api.model.dto.PqrsMensaje;



import co.udea.ssmu.api.model.entity.PqrsMensajeEntity;
import co.udea.ssmu.api.model.mapper.PqrsMensajeMapper;

import co.udea.ssmu.api.model.repository.PqrsMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PqrsMessageServiceImpl implements IPqrsMessageService {

    @Autowired
    PqrsMessageRepository pqrsMessageRepository;

    @Autowired
    PqrsMensajeMapper pqrsMessageMapper;

    @Override
    public PqrsMensaje createPqrsMessage(PqrsMensaje pqrsMessage) {
        PqrsMensajeEntity pqrsMessageE = pqrsMessageMapper.toEntity(pqrsMessage); // convertir el dto a entidad de base de datos

        pqrsMessageE = pqrsMessageRepository.save(pqrsMessageE); // guardar la entidad en la base de datos

        PqrsMensaje pqrsMessageResponse = pqrsMessageMapper.toDto(pqrsMessageE); // convertir la entidad a dto

        return pqrsMessageResponse;
    }


    @Override
    public PqrsMensaje deletePqrsMessage(Integer id) {
        Optional<PqrsMensajeEntity> pqrsMessageEResult  = pqrsMessageRepository.findById(id);

        if( ! pqrsMessageEResult.isPresent() ) {
            return null;
        }

        PqrsMensajeEntity pqrsMessageE = pqrsMessageEResult.get();
        pqrsMessageRepository.delete(pqrsMessageE);

        PqrsMensaje pqrsMessageResponse = pqrsMessageMapper.toDto(pqrsMessageE); // convertir la entidad a dto

        return pqrsMessageResponse;
    }

    @Override
    public Iterable<PqrsMensajeEntity> listPqrsMessage() {
        return pqrsMessageRepository.findAll();
    }

    @Override
    public PqrsMensaje getPqrsMessageById(Integer id) {
        Optional<PqrsMensajeEntity> pqrsMessageEResult  = pqrsMessageRepository.findById(id); // guardar la entidad en la base de datos

        if( ! pqrsMessageEResult.isPresent() ) {
            return null;
        }

        PqrsMensajeEntity pqrsMessageE = pqrsMessageEResult.get();
        PqrsMensaje pqrsMessageResponse = pqrsMessageMapper.toDto(pqrsMessageE); // convertir la entidad a dto

        return pqrsMessageResponse;
    }
}
