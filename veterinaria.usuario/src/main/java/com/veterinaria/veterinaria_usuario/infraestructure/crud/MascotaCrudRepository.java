package com.veterinaria.veterinaria_usuario.infraestructure.crud;

import com.veterinaria.veterinaria_usuario.application.domain.entity.Mascota;
import com.veterinaria.veterinaria_usuario.infraestructure.models.MascotaDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MascotaCrudRepository extends CrudRepository<MascotaDAO,String> {

    Optional<Mascota> findByIdNombre(String id);

    @Query(value = "select * from mascota where tratamiento = :tratamiento", nativeQuery=true)
    Optional<List<MascotaDAO>>  findByIdMascotaAndTratamiento(String tratamiento);
}
