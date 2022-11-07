package com.veterinaria.veterinaria_usuario.infraestructure.mappers;

import com.veterinaria.veterinaria_usuario.application.domain.entity.Mascota;
import com.veterinaria.veterinaria_usuario.infraestructure.models.MascotaDAO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;


import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface MascotaMapper {
    @Mappings({
            @Mapping(source = "idNombre",target = "idNombre"),
            @Mapping(source = "idUsuario",target = "idUsuario"),
            @Mapping(source = "tratamiento",target = "tratamiento"),
            @Mapping(source = "raza",target = "raza")


    })
    Mascota toMascota(MascotaDAO dao);

    List<Mascota> toMascotas(List<MascotaDAO> daos);

    // pasar de nuestro dominio a nuestra BD
    // target=users  es para indicar que ignore la relacion onetomany pq eso solo para BD
    @InheritInverseConfiguration
    @Mapping(target = "user",ignore = true )
    MascotaDAO toMascotaDAO(Mascota mascota);
}
