package com.veterinaria.veterinaria.consultas.persistence.mappers;

import com.veterinaria.veterinaria.consultas.domain.entities.Reserva;
import com.veterinaria.veterinaria.consultas.persistence.models.ReservaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-05T23:36:51-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class ReservaMapperImpl implements ReservaMapper {

    @Override
    public Reserva toReserva(ReservaDAO dao) {
        if ( dao == null ) {
            return null;
        }

        Reserva reserva = new Reserva();

        reserva.setIdReserva( dao.getIdReserva() );
        reserva.setIdMascota( dao.getIdMascota() );
        reserva.setIdUsuario( dao.getIdUsuario() );
        reserva.setIdVeterinaria( dao.getIdVeterinaria() );

        return reserva;
    }

    @Override
    public List<Reserva> toReservas(List<ReservaDAO> daos) {
        if ( daos == null ) {
            return null;
        }

        List<Reserva> list = new ArrayList<Reserva>( daos.size() );
        for ( ReservaDAO reservaDAO : daos ) {
            list.add( toReserva( reservaDAO ) );
        }

        return list;
    }

    @Override
    public ReservaDAO toReservaDAO(Reserva reserva) {
        if ( reserva == null ) {
            return null;
        }

        ReservaDAO reservaDAO = new ReservaDAO();

        reservaDAO.setIdReserva( reserva.getIdReserva() );
        reservaDAO.setIdMascota( reserva.getIdMascota() );
        reservaDAO.setIdUsuario( reserva.getIdUsuario() );
        reservaDAO.setIdVeterinaria( reserva.getIdVeterinaria() );

        return reservaDAO;
    }
}
