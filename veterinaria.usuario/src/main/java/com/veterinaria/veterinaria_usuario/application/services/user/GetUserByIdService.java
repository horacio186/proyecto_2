package com.veterinaria.veterinaria_usuario.application.services.user;

import com.veterinaria.veterinaria_usuario.application.domain.entity.User;
import com.veterinaria.veterinaria_usuario.application.ports.in.user.GetUserByIdUseCase;
import com.veterinaria.veterinaria_usuario.application.ports.out.user.UserGateways;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetUserByIdService  implements GetUserByIdUseCase {

    @Autowired
    private UserGateways gateway;

    @Override
    public Optional<User> execute(Integer idUsuario){
        return gateway.getByIdUsuario(idUsuario);
    }

}
