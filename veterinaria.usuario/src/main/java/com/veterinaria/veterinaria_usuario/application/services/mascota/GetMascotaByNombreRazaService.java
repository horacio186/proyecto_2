package com.veterinaria.veterinaria_usuario.application.services.mascota;

import com.veterinaria.veterinaria_usuario.application.domain.entity.Mascota;
import com.veterinaria.veterinaria_usuario.application.ports.in.mascota.GetMascotaByNombreRazaUseCase;
import com.veterinaria.veterinaria_usuario.application.ports.out.mascota.MascotaGateways;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class GetMascotaByNombreRazaService implements GetMascotaByNombreRazaUseCase {

    @Autowired
    private MascotaGateways gateway;

    @Override
    public List<Mascota> execute(String nombre, String raza) {

        return gateway.findByIdNombreOrRaza(nombre, raza);
    }

}
