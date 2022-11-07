package com.veterinaria.veterinaria_usuario.application.ports.in.user;

import com.veterinaria.veterinaria_usuario.application.domain.entity.User;
import com.veterinaria.veterinaria_usuario.commons.UseCase;

import java.util.List;

public interface GetAllUseCase extends UseCase<T, List<User>> {
}
