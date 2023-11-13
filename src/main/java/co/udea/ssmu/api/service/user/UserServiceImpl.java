package co.udea.ssmu.api.service.user;

import co.udea.ssmu.api.model.dto.Pqrs;
import co.udea.ssmu.api.model.dto.Usuario;
import co.udea.ssmu.api.model.entity.PqrsEntity;
import co.udea.ssmu.api.model.entity.UsuarioEntity;
import co.udea.ssmu.api.model.mapper.UsuarioMapperImpl;
import co.udea.ssmu.api.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    UsuarioMapperImpl   usuarioMapper;


    //Actualizar el estado de un usuario
    @Override
    public Usuario estadoUser(int idUser, Boolean estado) {
        Optional<UsuarioEntity> userResult  = userRepository.findById(idUser);

        //Verifico que exista el usuario
        if( ! userResult.isPresent() ) {
            return null;
        }

        //Obtengo el resultado y actualizo valores
        UsuarioEntity usuarioE = userResult.get();
        usuarioE.setHabilitado(estado);
        userRepository.save(usuarioE);

        // Convierte la entidad actualizada a DTO para la respuesta
        Usuario usuaioResponse = usuarioMapper.toDto(usuarioE);

        return usuaioResponse;
    }
}
