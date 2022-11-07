package com.veterinaria.veterinaria.consultas.web.controller;

import com.veterinaria.veterinaria.consultas.domain.entities.Reserva;
import com.veterinaria.veterinaria.consultas.domain.services.ReservaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService service;

    @GetMapping("/all")
    @ApiOperation(value = "Obtener todos las reservas ")
    @ApiResponse(code = 200,message = "OK")
    public ResponseEntity<List<Reserva>> getAll() throws Exception{

        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Buscar una reserva por Id")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK"),
            @ApiResponse(code = 404,message = "NOT FOUND")
    })
    public ResponseEntity<List<Reserva>> findReservaByIdReserva(@PathVariable("id") int id) throws Exception{
        return service.findReservaByIdReserva(id).map(td -> new ResponseEntity<>(td,HttpStatus.OK)).
                orElse(new ResponseEntity<>(null,HttpStatus.NOT_FOUND));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteReservaById(@PathVariable("id") int id) throws Exception{
        if(service.deleteReservaById(id) == true){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Reserva> saveReserva(@RequestBody Reserva reserva) throws Exception{
        return new ResponseEntity<>(service.saveReserva(reserva),HttpStatus.CREATED);
    }

}
