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






    private final PqrsMensajeMapper pqrsMessageMapper;
    private final PqrsMessageRepository pqrsMessageRepository;


    // Constructor for constructor injection
    @Autowired
    public PqrsMessageServiceImpl(PqrsMessageRepository pqrsMessageRepository, PqrsMensajeMapper pqrsMessageMapper) {
        this.pqrsMessageMapper = pqrsMessageMapper;
        this.pqrsMessageRepository = pqrsMessageRepository;
    }





    //Crear mensaje de una pqrs
    @Override
    public PqrsMensaje createPqrsMessage(PqrsMensaje pqrsMessage) {
        PqrsMensajeEntity pqrsMessageE = pqrsMessageMapper.toEntity(pqrsMessage); // convertir el dto a entidad de base de datos

        pqrsMessageE = pqrsMessageRepository.save(pqrsMessageE); // guardar la entidad en la base de datos



        return pqrsMessageMapper.toDto(pqrsMessageE);
    }


    //Eliminar mensaje de una pqrs
    @Override
    public PqrsMensaje deletePqrsMessage(Integer id) {
        Optional<PqrsMensajeEntity> pqrsMessageEResult  = pqrsMessageRepository.findById(id);

        if( ! pqrsMessageEResult.isPresent() ) {
            return null;
        }

        PqrsMensajeEntity pqrsMessageE = pqrsMessageEResult.get();
        pqrsMessageRepository.delete(pqrsMessageE);



        return pqrsMessageMapper.toDto(pqrsMessageE);
    }


    //Listar todos los mensajes existentes
    @Override
    public Iterable<PqrsMensajeEntity> listPqrsMessage() {
        return pqrsMessageRepository.findAll();
    }


    //Obtener un mensaje dado el id
    @Override
    public PqrsMensaje getPqrsMessageById(Integer id) {
        Optional<PqrsMensajeEntity> pqrsMessageEResult  = pqrsMessageRepository.findById(id); // guardar la entidad en la base de datos

        if( ! pqrsMessageEResult.isPresent() ) {
            return null;
        }

        PqrsMensajeEntity pqrsMessageE = pqrsMessageEResult.get();


        return pqrsMessageMapper.toDto(pqrsMessageE);
    }
}
