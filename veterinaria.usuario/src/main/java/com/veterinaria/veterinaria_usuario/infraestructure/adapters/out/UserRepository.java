package com.veterinaria.veterinaria_usuario.infraestructure.adapters.out;

import com.veterinaria.veterinaria_usuario.application.domain.entity.User;
import com.veterinaria.veterinaria_usuario.application.ports.out.user.UserGateways;
import com.veterinaria.veterinaria_usuario.infraestructure.crud.UserCrudRepository;
import com.veterinaria.veterinaria_usuario.infraestructure.mappers.UserMapper;
import com.veterinaria.veterinaria_usuario.infraestructure.models.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class UserRepository implements UserGateways {

    @Autowired(required = false)
    private UserCrudRepository crudRepository;
    @Autowired(required = false)
    private UserMapper mapper ;


    @Override
    public List<User> getAll() {
        List<UserDAO> users = (List<UserDAO>) crudRepository.findAll();
        return mapper.toUsers(users);
    }

   @Override
    public Optional<User> getByIdUsuario(int id) {

       UserDAO userDAO = crudRepository.findById(id).get();
       return Optional.ofNullable(mapper.toUser(userDAO));
    }


    @Override
    public User saveUser(User user) {
        UserDAO dao = mapper.toUserDAO(user);
        return mapper.toUser(crudRepository.save(dao));
    }

    @Override
    public void deleteUser(int id) {

       crudRepository.deleteById(id);
    }

    @Override
    public Optional<List<User>> findByIdUserAndTratamiento(String tratamiento) {
        return Optional.of(mapper.toUsers(crudRepository.findByIdUserAndTratamiento(tratamiento).get()));
    }

}
