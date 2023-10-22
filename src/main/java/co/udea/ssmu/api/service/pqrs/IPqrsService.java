package co.udea.ssmu.api.service.pqrs;


import co.udea.ssmu.api.model.dto.Pqrs;

import co.udea.ssmu.api.model.entity.PqrsEntity;


public interface IPqrsService {

    public Pqrs createPqrs(Pqrs pqrs);
    public Pqrs deletePqrs(Integer id);

    //Ajustar para solo mostrar las de usuario que me pasen
    public Iterable<PqrsEntity> listPqrs();
    public Pqrs getPqrsById(Integer id);

    public Pqrs updatePqrs(String pqrsState, Integer id);


    public Iterable<PqrsEntity> getPqrsByUsuario(Integer id);

    public Iterable<PqrsEntity> getPqrsByConductor(Integer id);

}
