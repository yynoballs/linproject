package com.lin.core.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class KafkaService {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;


    public void send(Map<String,String> map){
        ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send(map.get("topicName"), map.get("content"));
        try {
            System.out.println("发送结果:"+result.get().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
