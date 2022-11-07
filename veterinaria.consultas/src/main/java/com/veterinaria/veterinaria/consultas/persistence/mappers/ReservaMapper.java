package com.veterinaria.veterinaria.consultas.persistence.mappers;

import com.veterinaria.veterinaria.consultas.domain.entities.Reserva;
import com.veterinaria.veterinaria.consultas.persistence.models.ReservaDAO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    @Mappings({
            @Mapping(source = "idReserva",target = "idReserva"),
            @Mapping(source = "idMascota",target = "idMascota"),
            @Mapping(source = "idUsuario",target = "idUsuario"),
            @Mapping(source = "idVeterinaria",target = "idVeterinaria")

    })
    Reserva toReserva(ReservaDAO dao);
    List<Reserva> toReservas(List<ReservaDAO> daos);

    @InheritInverseConfiguration
    ReservaDAO toReservaDAO(Reserva reserva);

}
