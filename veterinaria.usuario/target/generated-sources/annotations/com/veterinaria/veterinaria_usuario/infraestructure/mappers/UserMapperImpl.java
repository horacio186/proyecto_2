package com.veterinaria.veterinaria_usuario.infraestructure.mappers;

import com.veterinaria.veterinaria_usuario.application.domain.entity.User;
import com.veterinaria.veterinaria_usuario.infraestructure.models.UserDAO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-05T09:35:41-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(UserDAO dao) {
        if ( dao == null ) {
            return null;
        }

        User user = new User();

        user.setIdUsuario( dao.getIdUsuario() );
        user.setNombre( dao.getNombre() );
        user.setMarcaEliminar( dao.getMarcaEliminar() );

        return user;
    }

    @Override
    public List<User> toUsers(List<UserDAO> daos) {
        if ( daos == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( daos.size() );
        for ( UserDAO userDAO : daos ) {
            list.add( toUser( userDAO ) );
        }

        return list;
    }

    @Override
    public UserDAO toUserDAO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDAO userDAO = new UserDAO();

        userDAO.setIdUsuario( user.getIdUsuario() );
        userDAO.setNombre( user.getNombre() );
        userDAO.setMarcaEliminar( user.getMarcaEliminar() );

        return userDAO;
    }
}
