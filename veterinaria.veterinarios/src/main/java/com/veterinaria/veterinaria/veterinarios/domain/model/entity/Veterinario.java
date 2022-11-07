package com.veterinaria.veterinaria.veterinarios.domain.model.entity;

import com.veterinaria.veterinaria.veterinarios.domain.model.entity.BaseEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("veterinario")
public class Veterinario  {


    @Id
    private String idVeterinario;
    private String numeroLicencia;
    private String nombre;

    public Veterinario() {
        super();
    }

    public String getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(String idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }




}
