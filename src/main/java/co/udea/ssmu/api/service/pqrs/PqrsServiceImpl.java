package co.udea.ssmu.api.service.pqrs;

import co.udea.ssmu.api.model.dto.Pqrs;
import co.udea.ssmu.api.model.entity.PqrsEntity;
import co.udea.ssmu.api.model.mapper.PqrsMapper;
import co.udea.ssmu.api.model.repository.PqrsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PqrsServiceImpl implements IPqrsService {

    @Autowired
    PqrsRepository pqrsRepository; // Repositorio para acceder a la base de datos

    @Autowired
    PqrsMapper pqrsMapper; // Mapper para convertir entre DTO y entidad


    //Crear Pqrs
    @Override
    public Pqrs createPqrs(Pqrs pqrs) {



        // Convierte el DTO a entidad de la base de datos
        PqrsEntity pqrsE = pqrsMapper.toEntity(pqrs);

        // Guarda la entidad en la base de datos
        pqrsE = pqrsRepository.save(pqrsE);



        return pqrsMapper.toDto(pqrsE);
    }


    //Eliminar Pqrs
    @Override
    public Pqrs deletePqrs(Integer id) {
        Optional<PqrsEntity> pqrsEResult  = pqrsRepository.findById(id);

        //Verifico que exista la pqrs
        if( ! pqrsEResult.isPresent() ) {
            return null;
        }

        PqrsEntity pqrsE = pqrsEResult.get();
        pqrsRepository.delete(pqrsE);



        return pqrsMapper.toDto(pqrsE);
    }


    //Listar pqrs
    @Override
    public Iterable<PqrsEntity> listPqrs() {
        return pqrsRepository.findAll();
    }


    //Obtener pqrs por id
    @Override
    public Pqrs getPqrsById(Integer id) {
        Optional<PqrsEntity> pqrsEResult  = pqrsRepository.findById(id);

        //Verifico que exista la pqrs
        if( ! pqrsEResult.isPresent() ) {
            return null;
        }

        PqrsEntity pqrsE = pqrsEResult.get();






        return pqrsMapper.toDto(pqrsE);
    }

    //Update pqrs
    @Override
    public Pqrs updatePqrs(String pqrsState, Integer id) {

        Optional<PqrsEntity> pqrsEResult  = pqrsRepository.findById(id);

        //Verifico que exista la pqrs
        if( ! pqrsEResult.isPresent() ) {
            return null;
        }

        //Obtengo el resultado y actualizo valores
        PqrsEntity pqrsE = pqrsEResult.get();
        pqrsE.setEstadoPqrs(pqrsState);
        pqrsRepository.save(pqrsE);



        return pqrsMapper.toDto(pqrsE);
    }


    //Obtener pqrs dado el usuario creador de tipo User
    @Override
    public Iterable<PqrsEntity> getPqrsByUsuario(Integer id) {


        return pqrsRepository.findAllByCreadoPorAndCreadoPorRol(id,"User");
    }


    //Obtener pqrs dado el conductor creador de tipo Conductor
    @Override
    public Iterable<PqrsEntity> getPqrsByConductor(Integer id) {
        return  pqrsRepository.findAllByCreadoPorAndCreadoPorRol(id,"Conductor");
    }


    //aprovar o rechazar una pqrs
    @Override
    public Pqrs aprovarRechazarPqrs(String pqrsEstadoAprovacion, Integer id) {
        Optional<PqrsEntity> pqrsEResult  = pqrsRepository.findById(id);

        //Verifico que exista la pqrs
        if( ! pqrsEResult.isPresent() ) {
            return null;
        }

        //Obtengo el resultado y actualizo valores
        PqrsEntity pqrsE = pqrsEResult.get();
        pqrsE.setEstadoAprobacion(pqrsEstadoAprovacion);
        pqrsRepository.save(pqrsE);



        return  pqrsMapper.toDto(pqrsE);
    }
}
