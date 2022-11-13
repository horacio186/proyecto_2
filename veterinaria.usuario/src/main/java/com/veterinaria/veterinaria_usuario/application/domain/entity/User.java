package com.veterinaria.veterinaria_usuario.application.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

import java.util.Optional;


@NoArgsConstructor
@Getter
@Setter
public class User {

    private int idUsuario;
    private String nombre;
    private String marcaEliminar;



    //private List<Mascota> mascotas;


}
