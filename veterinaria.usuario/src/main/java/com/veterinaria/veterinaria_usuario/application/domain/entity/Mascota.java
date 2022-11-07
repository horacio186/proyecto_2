package com.veterinaria.veterinaria_usuario.application.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Mascota {

    private String idNombre;
    private String tratamiento;
    private String raza;
    private int idUsuario;
    //private UserDAO user;




}
