package com.veterinaria.veterinaria.consultas.domain.gateways;

import com.veterinaria.veterinaria.consultas.domain.entities.Reserva;

import java.util.List;
import java.util.Optional;

public interface ReservaGateway {

    List<Reserva> getAll();
    Optional<List<Reserva>> findReservaByIdReserva(int id);
    Reserva saveReserva(Reserva reserva);
    void deleteReserva(int id);

}
