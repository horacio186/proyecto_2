package com.veterinaria.veterinaria.consultas.persistence;

import com.veterinaria.veterinaria.consultas.domain.entities.Reserva;
import com.veterinaria.veterinaria.consultas.domain.gateways.ReservaGateway;
import com.veterinaria.veterinaria.consultas.persistence.crud.ReservaCrudRepository;
import com.veterinaria.veterinaria.consultas.persistence.mappers.ReservaMapper;
import com.veterinaria.veterinaria.consultas.persistence.models.ReservaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class ReservaRepository implements ReservaGateway {

    @Autowired
    private ReservaCrudRepository crudRepository;
    @Autowired
    private ReservaMapper mapper ;


    @Override
    public List<Reserva> getAll() {
        List<ReservaDAO> reservas = (List<ReservaDAO>) crudRepository.findAll();
        return mapper.toReservas(reservas);
    }

    @Override
    public Optional<List<Reserva>> findReservaByIdReserva(int id) {
        return crudRepository.findReservaByIdReserva(id);
    }


    @Override
    public Reserva saveReserva(Reserva usuario) {
        ReservaDAO dao = mapper.toReservaDAO(usuario);
        return mapper.toReserva(crudRepository.save(dao));
    }

    @Override
    public void deleteReserva(int id) {
        crudRepository.deleteById(id);
    }


}
