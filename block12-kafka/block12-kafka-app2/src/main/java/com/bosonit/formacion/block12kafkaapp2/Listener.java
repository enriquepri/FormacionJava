package com.bosonit.formacion.block12kafkaapp2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {
    @Autowired
    MessageProducer kafkaMessageProducer;

    @Value(value = "${message.topic.name2:dos}")
    private String topic;

    @KafkaListener(topics = "${message.topic.name1:uno}", groupId = "${message.group.name:myGroup}")
    public void listenTopic(String message) {
        System.out.println("Received Message of topic1 in listener: " + message);

        String respuesta = "Respuesta a: " + message;
        kafkaMessageProducer.sendMessage(topic,respuesta);
    }
}
