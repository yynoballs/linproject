package com.lin.core.controller;

import com.lin.core.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("kafka")
public class KafkaController {

    @Autowired
    private KafkaService kafkaService;

    @PostMapping("send")
    public void send(@RequestBody Map<String,String> map){
        kafkaService.send(map);
    }
}
