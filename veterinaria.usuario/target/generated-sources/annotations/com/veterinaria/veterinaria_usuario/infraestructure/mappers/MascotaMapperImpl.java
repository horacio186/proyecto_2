package com.veterinaria.veterinaria_usuario.infraestructure.mappers;

import com.veterinaria.veterinaria_usuario.application.domain.entity.Mascota;
import com.veterinaria.veterinaria_usuario.infraestructure.models.MascotaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-06T18:14:38-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class MascotaMapperImpl implements MascotaMapper {

    @Override
    public Mascota toMascota(MascotaDAO dao) {
        if ( dao == null ) {
            return null;
        }

        Mascota mascota = new Mascota();

        mascota.setIdNombre( dao.getIdNombre() );
        mascota.setIdUsuario( dao.getIdUsuario() );
        mascota.setTratamiento( dao.getTratamiento() );
        mascota.setRaza( dao.getRaza() );

        return mascota;
    }

    @Override
    public List<Mascota> toMascotas(List<MascotaDAO> daos) {
        if ( daos == null ) {
            return null;
        }

        List<Mascota> list = new ArrayList<Mascota>( daos.size() );
        for ( MascotaDAO mascotaDAO : daos ) {
            list.add( toMascota( mascotaDAO ) );
        }

        return list;
    }

    @Override
    public MascotaDAO toMascotaDAO(Mascota mascota) {
        if ( mascota == null ) {
            return null;
        }

        MascotaDAO mascotaDAO = new MascotaDAO();

        mascotaDAO.setIdNombre( mascota.getIdNombre() );
        mascotaDAO.setIdUsuario( mascota.getIdUsuario() );
        mascotaDAO.setTratamiento( mascota.getTratamiento() );
        mascotaDAO.setRaza( mascota.getRaza() );

        return mascotaDAO;
    }
}
