package com.veterinaria.veterinaria_usuario.infraestructure.adapters.out;

import com.veterinaria.veterinaria_usuario.application.domain.entity.Mascota;
import com.veterinaria.veterinaria_usuario.application.ports.out.mascota.MascotaGateways;
import com.veterinaria.veterinaria_usuario.infraestructure.crud.MascotaCrudRepository;
import com.veterinaria.veterinaria_usuario.infraestructure.mappers.MascotaMapper;
import com.veterinaria.veterinaria_usuario.infraestructure.models.MascotaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class MascotaRepository implements MascotaGateways {

    @Autowired(required = false)
    private MascotaCrudRepository crudRepository;
    @Autowired(required = false)
    private MascotaMapper mapper ;


    @Override
    public List<Mascota> getAll() {
        List<MascotaDAO> mascotas = (List<MascotaDAO>) crudRepository.findAll();
        return mapper.toMascotas(mascotas);
    }

    @Override
    public Optional<Mascota> findByIdNombre(String id) {

        return crudRepository.findByIdNombre(id);
    }


    @Override
    public Mascota saveMascota(Mascota mascota) {
        MascotaDAO dao = mapper.toMascotaDAO(mascota);
        return mapper.toMascota(crudRepository.save(dao));
    }

    @Override
    public void deleteMascota(String id) {

        crudRepository.deleteById(id);
    }

    @Override
    public Optional<List<Mascota>> findByIdMascotaAndTratamiento(String tratamiento) {
        return Optional.of(mapper.toMascotas(crudRepository.findByIdMascotaAndTratamiento(tratamiento).get()));
    }

}
