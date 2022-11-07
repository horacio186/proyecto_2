package com.veterinaria.veterinaria_usuario.infraestructure.crud;

import com.veterinaria.veterinaria_usuario.application.domain.entity.User;
import com.veterinaria.veterinaria_usuario.infraestructure.models.UserDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface UserCrudRepository extends CrudRepository<UserDAO,Integer> {


    Optional<User> findById(int id);

    @Query(value = "select * from usuario u join mascota m on u.id_usuario = m.id_usuario where tratamiento = :tratamiento", nativeQuery=true)
    Optional<List<UserDAO>>  findByIdUserAndTratamiento(String tratamiento);

}
