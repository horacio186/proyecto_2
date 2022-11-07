package com.veterinaria.veterinaria_usuario.infraestructure.adapters.in;

import com.veterinaria.veterinaria_usuario.application.domain.entity.Mascota;
import com.veterinaria.veterinaria_usuario.application.services.mascota.MascotaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService service;

    @GetMapping("/all")
    @ApiOperation(value = "Obtener todos las mascotas ")
    @ApiResponse(code = 200,message = "OK")
    public ResponseEntity<List<Mascota>> getAll() throws Exception{

        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar una mascota por Id")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK"),
            @ApiResponse(code = 404,message = "NOT FOUND")
    })
    public ResponseEntity<Mascota> findByIdNombre(@PathVariable("id") String id) throws Exception{
        return service.findByIdNombre(id).map(td -> new ResponseEntity<>(td,HttpStatus.OK)).
                orElse(new ResponseEntity<>(null,HttpStatus.NOT_FOUND));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteMascotaById(@PathVariable("id") String id) throws Exception{
        if(service.deleteMascotaById(id) == true){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Mascota> saveMascota(@RequestBody Mascota mascota) throws Exception{
        return new ResponseEntity<>(service.saveMascota(mascota),HttpStatus.CREATED);
    }

}
