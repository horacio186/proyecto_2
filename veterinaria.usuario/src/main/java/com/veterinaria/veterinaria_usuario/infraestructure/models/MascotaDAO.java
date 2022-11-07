package com.veterinaria.veterinaria_usuario.infraestructure.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "mascota")
public class MascotaDAO {

    @Id
    @Column(name = "id_nombre", length = 50)
    private String idNombre;

    @Column(length = 1)
    private String tratamiento;

    @Column(length = 50)
    private String raza;

    @Column(name = "id_usuario")
    private int idUsuario;

   @ManyToOne
    @JoinColumn(name = "id_usuario",insertable = false,updatable = false, foreignKey = @ForeignKey(name = "FK_usuario_mascota"))
    private UserDAO user;


}
