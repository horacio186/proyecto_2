package com.veterinaria.veterinaria.veterinarios.domain.model.entity;

import com.veterinaria.veterinaria.veterinarios.domain.model.entity.Entity;

public abstract class BaseEntity<T> extends Entity<T> {

    private boolean isModified;

    /**
     * @param id
     * @param name
     */
    public BaseEntity(T id, String name) {
        super.id = id;
        super.name = name;
        isModified = false;
    }

    public BaseEntity() {

    }

    /**
     *
     * @return
     */
    public boolean isIsModified() {
        return isModified;
    }

}
