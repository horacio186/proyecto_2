package com.veterinaria.veterinaria.consultas.persistence.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//@Getter
//@Setter
@Entity
@Table(name = "reserva")
public class ReservaDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private int idReserva;

    @Column(name = "id_mascota")
    private String idMascota;

    @Column(name = "id_usuario")
    private String idUsuario;

    @Column(name = "id_veterinaria")
    private String idVeterinaria;

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(String idMascota) {
        this.idMascota = idMascota;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdVeterinaria() {
        return idVeterinaria;
    }

    public void setIdVeterinaria(String idVeterinaria) {
        this.idVeterinaria = idVeterinaria;
    }
}
