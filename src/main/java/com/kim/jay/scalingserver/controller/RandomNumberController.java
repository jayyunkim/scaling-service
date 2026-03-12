package com.kim.jay.scalingserver.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;

@RestController
@RequestMapping("/randomnumber")
public class RandomNumberController {
    private final Random random = new Random();

    @GetMapping("/int")
    public int getRandomInt() {
        return random.nextInt();
    }

    @GetMapping("/reactive-int")
    public reactor.core.publisher.Mono<Integer> getReactiveRandomInt() {
        return reactor.core.publisher.Mono.just(random.nextInt());
    }

    @GetMapping("/reactive-string")
    public reactor.core.publisher.Mono<String> getReactiveRandomString() {
        return reactor.core.publisher.Mono.just(String.valueOf(random.nextInt()));
    }

    @GetMapping(value = "/stream", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Integer> streamRandomInts() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(tick -> random.nextInt())
                .take(10); // Stream 10 random ints, adjust as needed
    }
}
