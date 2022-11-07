package com.veterinaria.veterinaria_usuario.application.ports.in.mascota;

import com.veterinaria.veterinaria_usuario.application.domain.entity.Mascota;
import com.veterinaria.veterinaria_usuario.application.domain.entity.User;
import com.veterinaria.veterinaria_usuario.commons.UseCaseMascota;

import java.util.Optional;

public interface GetMascotaByIdUseCase extends UseCaseMascota<String, Optional<Mascota>> {
}
