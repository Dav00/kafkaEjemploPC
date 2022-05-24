package org.davo.davo.Controller;

import org.davo.davo.Entity.Persona;
import org.davo.davo.Service.ServicePersonaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class ControllerPersona {
    @Autowired
    ServicePersonaProducer service;

    @GetMapping("/todos")
    public List<Persona> verTodasPersonas(){
        try{
            return service.verTodos();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    e.getMessage());
        }

    }
    @PostMapping("/crear")
    public void crearPersona(@RequestBody Persona persona){
        try{
            service.crearPersona(persona);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    e.getMessage());
        }
    }
}
