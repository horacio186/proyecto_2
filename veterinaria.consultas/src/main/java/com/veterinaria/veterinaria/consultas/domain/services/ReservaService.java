package com.veterinaria.veterinaria.consultas.domain.services;

import com.veterinaria.veterinaria.consultas.domain.entities.Reserva;
import com.veterinaria.veterinaria.consultas.domain.gateways.ReservaGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaGateway gateway;

    public List<Reserva> getAll(){
        return gateway.getAll();
    }

    public Optional<List<Reserva>> findReservaByIdReserva(int id ) {
        return gateway.findReservaByIdReserva(id);
    }

    public Reserva saveReserva(Reserva reserva){
        return gateway.saveReserva(reserva);
    }

    public boolean deleteReservaById(int id){
        return findReservaByIdReserva(id).map(td -> {
            gateway.deleteReserva(id);
            return true;
        }).orElse(false);
    }

}
