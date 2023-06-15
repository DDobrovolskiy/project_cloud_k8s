package ru.cloud.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@Log4j2
public class TestController {
    private Random random = new Random();

    @GetMapping
    public String getTest() {
        log.info("GetTest");
        try {
            Thread.sleep(random.nextInt(10) * 100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "GetTest";
    }
}
