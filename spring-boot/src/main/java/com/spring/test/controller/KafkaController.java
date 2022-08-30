package com.spring.test.controller;

import com.spring.test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class KafkaController {

  private static final String TOPIC = "kafka_example";
  @Autowired private KafkaTemplate<String, User> kafkaTemplate;

  @GetMapping("/publish/{name}")
  public String message(@PathVariable("name") final String name) {
    kafkaTemplate.send(TOPIC, new User(name, "tec", 12L));
    return "Successfully publish the message.";
  }
}
