package com.veterinaria.veterinaria.veterinarios.domain.gateway;

import java.util.List;
import java.util.Optional;

public interface VeterinariaGateways {
    List<VeterinariaGateways> getAll();

    Optional<VeterinariaGateways> findByregistroNacional(String id);

    VeterinariaGateways saveVeterinaria(VeterinariaGateways veterinaria);

    void deleteVeterinaria(String id);

}
