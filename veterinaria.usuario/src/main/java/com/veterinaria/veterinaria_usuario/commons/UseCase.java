package com.veterinaria.veterinaria_usuario.commons;

public interface UseCase<Input, Output> {
    Output execute(Input input);
}
