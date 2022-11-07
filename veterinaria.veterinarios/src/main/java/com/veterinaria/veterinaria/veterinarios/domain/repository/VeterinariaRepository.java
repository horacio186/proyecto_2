package com.veterinaria.veterinaria.veterinarios.domain.repository;

import com.veterinaria.veterinaria.veterinarios.domain.model.entity.Veterinaria;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VeterinariaRepository extends MongoRepository<Veterinaria, String> {

    Veterinaria findByRegistroNacional(String licencia);

    Boolean existsByIdVeterinario(String idVeterinario);
}
