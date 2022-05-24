package org.davo.davo.Service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @KafkaListener(topics = "ejemplo", groupId = "group")
    public void consumir(String mensaje) {
        System.out.println("Consumidor: "+mensaje);
    }
}
