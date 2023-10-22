package co.udea.ssmu.api.service.pqrsMessage;

import co.udea.ssmu.api.model.dto.PqrsMensaje;

import co.udea.ssmu.api.model.entity.PqrsMensajeEntity;


public interface IPqrsMessageService {

    public PqrsMensaje createPqrsMessage(PqrsMensaje pqrsMessage);
    public PqrsMensaje deletePqrsMessage(Integer id);
    public Iterable<PqrsMensajeEntity> listPqrsMessage();
    public PqrsMensaje getPqrsMessageById(Integer id);

}
