package com.veterinaria.veterinaria_usuario.application.services.mascota;

import com.veterinaria.veterinaria_usuario.application.domain.entity.Mascota;
import com.veterinaria.veterinaria_usuario.application.ports.in.mascota.GetMascotaByIdUseCase;
import com.veterinaria.veterinaria_usuario.application.ports.out.mascota.MascotaGateways;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetMascotaByIdService implements GetMascotaByIdUseCase {

    @Autowired
    private MascotaGateways gateway;

    @Override
    public Optional<Mascota> execute(String id){
        return gateway.findByIdNombre(id);
    }
}
