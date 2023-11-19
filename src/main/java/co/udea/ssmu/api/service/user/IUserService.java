package co.udea.ssmu.api.service.user;


import co.udea.ssmu.api.model.dto.Usuario;

public interface IUserService {

    public Usuario estadoUser(int idUser, Boolean estado);

}
