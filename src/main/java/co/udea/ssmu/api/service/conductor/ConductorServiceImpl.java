package co.udea.ssmu.api.service.conductor;


import co.udea.ssmu.api.model.dto.Conductor;
import co.udea.ssmu.api.model.entity.ConductorEntity;

import co.udea.ssmu.api.model.mapper.ConductorMapper;

import co.udea.ssmu.api.model.repository.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConductorServiceImpl implements IConductorService{




    private final ConductorRepository conductorRepository;
    private final ConductorMapper conductorMapper;


    // Constructor for constructor injection
    @Autowired
    public ConductorServiceImpl(ConductorMapper conductorMapper, ConductorRepository conductorRepository) {
        this.conductorRepository = conductorRepository;
        this.conductorMapper = conductorMapper;
    }


    //Cambiar estado de un conductor
    @Override
    public Conductor estadoConductor(int idConductor, Boolean estado) {

        Optional<ConductorEntity> conductorResult  = conductorRepository.findById(idConductor);

        //Verifico que exista el usuario
        if( ! conductorResult.isPresent() ) {
            return null;
        }

        //Obtengo el resultado y actualizo valores
        ConductorEntity conductorE = conductorResult.get();
        conductorE.setHabilitado(estado);
        conductorRepository.save(conductorE);


        return conductorMapper.toDto(conductorE);
    }
}
