package com.veterinaria.veterinaria_usuario.infraestructure.adapters.in;

import com.veterinaria.veterinaria_usuario.application.domain.entity.User;
import com.veterinaria.veterinaria_usuario.application.services.user.GetUserByIdService;
import com.veterinaria.veterinaria_usuario.application.services.user.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private GetUserByIdService getById;

    @GetMapping("/all")
    @ApiOperation(value = "Obtener todos los usuarios ")
    @ApiResponse(code = 200,message = "OK")
    public ResponseEntity<List<User>> getAll() throws Exception{

        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar un usuario por Id")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK"),
            @ApiResponse(code = 404,message = "NOT FOUND")
    })
    public ResponseEntity<Optional<User>> getById(@PathVariable int id) {
        return new ResponseEntity<>(getById.execute(id), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteUserById(@PathVariable("id") int id) throws Exception{
        if(service.deleteUserById(id) == true){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) throws Exception{
        return new ResponseEntity<>(service.saveUser(user),HttpStatus.CREATED);
    }

}
