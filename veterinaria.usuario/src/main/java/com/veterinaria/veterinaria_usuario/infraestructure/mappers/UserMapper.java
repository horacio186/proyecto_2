package com.veterinaria.veterinaria_usuario.infraestructure.mappers;
import com.veterinaria.veterinaria_usuario.application.domain.entity.User;
import com.veterinaria.veterinaria_usuario.infraestructure.models.UserDAO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


import java.util.List;
@Mapper(componentModel = "spring",uses = {MascotaMapper.class} )
public interface UserMapper {

    @Mappings({
            @Mapping(source = "idUsuario",target = "idUsuario"),
            @Mapping(source = "nombre",target = "nombre"),
            @Mapping(source = "marcaEliminar",target = "marcaEliminar")


    })
    User toUser(UserDAO dao);
    List<User> toUsers(List<UserDAO> daos);

    // pasar de nuestro dominio a nuestra BD
    // target=users  es para indicar que ignore la relacion onetomany pq eso solo para BD
    @InheritInverseConfiguration
    @Mapping(target = "mascotas",ignore = true )
    UserDAO toUserDAO(User user);

}
