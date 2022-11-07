package com.veterinaria.veterinaria.veterinarios.domain.gateway;

import com.veterinaria.veterinaria.veterinarios.domain.model.entity.Veterinario;

import java.util.List;
import java.util.Optional;

public interface VeterinarioGateways {

    List<Veterinario> getAll();

    Optional<Veterinario> findByIdnumeroLicencia(String id);

    Veterinario saveVeterinario(Veterinario veterinario);

    void deleteVeterinario(String id);

}
