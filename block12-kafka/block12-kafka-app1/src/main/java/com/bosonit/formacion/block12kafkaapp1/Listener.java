package com.bosonit.formacion.block12kafkaapp1;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {
    @KafkaListener(topics = "${message.topic.name2:dos}", groupId = "${message.group.name:myGroup}")
    public void listenTopic(String message) {
        System.out.println("Received Message of topic2 in listener: " + message);
    }
}
