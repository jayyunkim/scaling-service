package com.kim.jay.scalingserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("randomnumberwithalpha")
public class RandomNumberWithAlphaController {

    private static final String ALPHA = "alpha";
    private final Random random = new Random();

    @GetMapping
    @RequestMapping("/int")
    public String getRandomInt() {
        return random.nextInt() + ALPHA;
    }
}
