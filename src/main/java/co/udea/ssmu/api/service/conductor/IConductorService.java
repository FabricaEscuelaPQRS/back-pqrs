package co.udea.ssmu.api.service.conductor;

import co.udea.ssmu.api.model.dto.Conductor;


public interface IConductorService {
    public Conductor estadoConductor(int idConductor, Boolean estado);

}
