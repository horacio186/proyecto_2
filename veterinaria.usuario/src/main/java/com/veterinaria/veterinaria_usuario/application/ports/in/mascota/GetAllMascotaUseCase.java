package com.veterinaria.veterinaria_usuario.application.ports.in.mascota;

import com.veterinaria.veterinaria_usuario.application.domain.entity.User;
import com.veterinaria.veterinaria_usuario.application.ports.in.user.T;
import com.veterinaria.veterinaria_usuario.commons.UseCaseMascota;

import java.util.List;

public interface GetAllMascotaUseCase extends UseCaseMascota<T, List<User>> {
}
