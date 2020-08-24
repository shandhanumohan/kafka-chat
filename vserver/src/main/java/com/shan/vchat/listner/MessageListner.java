package com.shan.vchat.listner;

import com.shan.vchat.constants.KafkaConstants;
import com.shan.vchat.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageListner {

    @Autowired
    private SimpMessagingTemplate template;

    @KafkaListener(topics = KafkaConstants.KAFKA_TOPIC, groupId = KafkaConstants.GROUP_ID)
    public void listen(Message message) {
        template.convertAndSend("/topic/group", message);

    }
}
