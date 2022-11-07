package com.veterinaria.veterinaria_usuario.application.ports.out.user;

import com.veterinaria.veterinaria_usuario.application.domain.entity.Mascota;
import com.veterinaria.veterinaria_usuario.application.domain.entity.User;
import com.veterinaria.veterinaria_usuario.infraestructure.models.UserDAO;

import java.util.List;
import java.util.Optional;

public interface UserGateways {


    List<User> getAll();

    Optional<User> findById(int id);

    User saveUser(User usuario);

    void deleteUser(int id);

    Optional<List<User>>  findByIdUserAndTratamiento(String tratamiento);



}
