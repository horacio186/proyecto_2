package com.veterinaria.veterinaria_usuario.application.ports.out.mascota;

import com.veterinaria.veterinaria_usuario.application.domain.entity.Mascota;
import com.veterinaria.veterinaria_usuario.infraestructure.models.MascotaDAO;

import java.util.List;
import java.util.Optional;

public interface MascotaGateways {

    List<Mascota> getAll();

    Optional<Mascota> findByIdNombre(String id);

    List<Mascota> findByIdNombreOrRaza(String nombre, String raza);

    Mascota saveMascota(Mascota mascota);

    void deleteMascota(String id);

    Optional<List<Mascota>>  findByIdMascotaAndTratamiento(String tratamiento);

}
