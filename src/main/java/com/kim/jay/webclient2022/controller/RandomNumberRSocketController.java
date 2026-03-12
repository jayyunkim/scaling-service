package com.kim.jay.webclient2022.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;

@Controller
public class RandomNumberRSocketController {
    private final Random random = new Random();

    @MessageMapping("random.int.stream")
    public Flux<Integer> streamRandomInts() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(tick -> random.nextInt());
    }
}

