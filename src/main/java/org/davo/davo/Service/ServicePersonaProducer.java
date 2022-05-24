package org.davo.davo.Service;

import org.davo.davo.Entity.Persona;
import org.davo.davo.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class ServicePersonaProducer {
    @Autowired
    PersonaRepository personaRepository;
    final KafkaTemplate<String, String> kafkaTemplate;

    public ServicePersonaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void crearPersona(Persona persona) {
        try {
            comprobarDNI(persona.getDni());
            personaRepository.insert(persona);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    e.getMessage());
        }
        //Preguntar a ver si el DNI está bien
    }

    private void comprobarDNI(String DNI) {
        kafkaTemplate.send("ejemplo",String.valueOf(new Persona(1,DNI,"Pepito","Jose",21)))
                .addCallback(
                        result -> System.out.println("Message sent to topic: {}"+ DNI),
                        ex -> System.out.println("Failed to send message"+ ex)
                );
    }

    public List<Persona> verTodos() {
        return personaRepository.findAll();
    }
}
