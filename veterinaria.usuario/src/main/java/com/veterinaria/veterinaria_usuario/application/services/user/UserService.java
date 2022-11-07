package com.veterinaria.veterinaria_usuario.application.services.user;
import com.veterinaria.veterinaria_usuario.application.domain.entity.User;
import com.veterinaria.veterinaria_usuario.application.ports.out.user.UserGateways;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserGateways gateway;

    public List<User> getAll(){
        return gateway.getAll();
    }

    public Optional<User> findById(int id ) {
        return gateway.findById(id);
    }

    public Optional<User> findByIdUserAndTratamiento(String tratamiento, int id) {

        return gateway.findById(id);
    }

    public User saveUser(User user){
        return gateway.saveUser(user);
    }

    public boolean deleteUserById(int id){
        return findByIdUserAndTratamiento("1", id).map(td -> {
            gateway.deleteUser(id);
            return true;
        }).orElse(false);
    }

}
