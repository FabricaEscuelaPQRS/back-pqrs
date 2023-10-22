package co.udea.ssmu.api.service.pqrsMessage;

import co.udea.ssmu.api.model.dto.PqrsMessage;
import co.udea.ssmu.api.model.entity.PqrsMessageE;

public interface IPqrsMessageService {

    public PqrsMessage createPqrsMessage(PqrsMessage pqrsMessage);
    public PqrsMessage deletePqrsMessage(Integer id);
    public Iterable<PqrsMessageE> listPqrsMessage();
    public PqrsMessage getPqrsMessageById(Integer id);

}
