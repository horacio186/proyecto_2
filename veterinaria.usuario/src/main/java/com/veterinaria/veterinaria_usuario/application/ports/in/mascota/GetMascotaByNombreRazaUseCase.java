package com.veterinaria.veterinaria_usuario.application.ports.in.mascota;

import com.veterinaria.veterinaria_usuario.application.domain.entity.Mascota;
import com.veterinaria.veterinaria_usuario.commons.UseCaseMascota;
import com.veterinaria.veterinaria_usuario.commons.UseCaseMascotaNombreRaza;

import java.util.List;
import java.util.Optional;

public interface GetMascotaByNombreRazaUseCase extends UseCaseMascotaNombreRaza<String, String, List<Mascota>> {

}
