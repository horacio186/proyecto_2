package com.veterinaria.veterinaria.veterinarios.resources;

import com.veterinaria.veterinaria.veterinarios.common.veterinaria.InvalidVeterinariaException;
import com.veterinaria.veterinaria.veterinarios.common.veterinaria.VeterinariaNotFoundException;
import com.veterinaria.veterinaria.veterinarios.common.veterinario.VeterinarioNotFoundException;
import com.veterinaria.veterinaria.veterinarios.domain.model.entity.Veterinaria;
import com.veterinaria.veterinaria.veterinarios.domain.service.VeterinariaService;
import com.veterinaria.veterinaria.veterinarios.domain.valueobject.VeterinariaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/veterinaria")
public class VeterinariaController {

    @Autowired
    private VeterinariaService service;

    @PostMapping("/save")
    public ResponseEntity<Veterinaria> add(@RequestBody Veterinaria veterinaria) throws InvalidVeterinariaException, VeterinarioNotFoundException {
        Veterinaria vet = service.createVeterinaria(veterinaria);
        return new ResponseEntity<>(vet, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Veterinaria>> listarVeterinarias() {
        List<Veterinaria> veterinarias = service.findAll();
        return new ResponseEntity<>(veterinarias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veterinaria> obtenerVeterinaria(@PathVariable String id) {
        Veterinaria veterinaria = service.findByRegistroNacional(id);
        return new ResponseEntity<>(veterinaria, HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Veterinaria> editarVeterinaria(@PathVariable String id, @RequestBody VeterinariaVO vo) throws VeterinariaNotFoundException, VeterinarioNotFoundException {
        Veterinaria veterinaria = service.updateVeterinaria(id, vo);
        return new ResponseEntity<>(veterinaria, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteVeterinaria(@PathVariable String id) throws VeterinariaNotFoundException {
        service.deleteVeterinaria(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
