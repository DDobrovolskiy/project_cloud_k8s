package ru.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class TestController {
    private Random random = new Random();

    @GetMapping
    public String getTest() {
        try {
            Thread.sleep(random.nextInt(10) * 100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "GetTest";
    }
}
