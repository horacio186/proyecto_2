package com.veterinaria.veterinaria.veterinarios.domain.repository;

import com.veterinaria.veterinaria.veterinarios.domain.model.entity.Veterinario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VeterinarioRepository extends MongoRepository<Veterinario, String> {

    Veterinario findByNumeroLicencia(String licencia);

    Boolean existsVeterinarioByNumeroLicencia(String licencia);

}
