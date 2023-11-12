package com.lin.core.Message;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class kafkaConsumer {
    //监听一个或多个topic
    @KafkaListener(topics = "springCloud-topic")
    public void handler(String message){
        System.out.println("收到消息:"+message);
    }
}
