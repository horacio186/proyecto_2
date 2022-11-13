package com.veterinaria.veterinaria_usuario.application.services.mascota;

import com.veterinaria.veterinaria_usuario.application.domain.entity.Mascota;
import com.veterinaria.veterinaria_usuario.application.ports.out.mascota.MascotaGateways;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class MascotaService {

    @Autowired(required = false)
    private MascotaGateways gateway;

    public List<Mascota> getAll(){
        return gateway.getAll();
    }


    public Optional<List<Mascota>> findByIdMascotaAndTratamiento(String tratamiento, String id) {

        return gateway.findByIdMascotaAndTratamiento(tratamiento);
    }

    public Mascota saveMascota(Mascota mascota){
        return gateway.saveMascota(mascota);
    }

    public boolean deleteMascotaById(String id){
        return findByIdMascotaAndTratamiento("1", id).map(td -> {
            gateway.deleteMascota(id);
            return true;
        }).orElse(false);
    }


}
