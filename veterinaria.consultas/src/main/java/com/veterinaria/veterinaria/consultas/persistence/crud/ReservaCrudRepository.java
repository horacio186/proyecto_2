package com.veterinaria.veterinaria.consultas.persistence.crud;

import com.veterinaria.veterinaria.consultas.domain.entities.Reserva;
import com.veterinaria.veterinaria.consultas.persistence.models.ReservaDAO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ReservaCrudRepository extends CrudRepository<ReservaDAO,Integer> {

    Optional<List<Reserva>> findReservaByIdReserva(int id);
}
