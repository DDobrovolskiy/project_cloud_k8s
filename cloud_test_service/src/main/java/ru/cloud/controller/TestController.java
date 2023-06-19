package ru.cloud.controller;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.util.StringBuilders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@Log4j2
public class TestController {
    private Random random = new Random();

    @Value("${instance.name}")
    private String name;
    @Value("${instance.secret}")
    private String secret;

    @GetMapping
    public String getTest() {
        log.info("GetTest");
        log.info(name);
        log.info(secret);
        try {
            Thread.sleep(random.nextInt(10) * 100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name).append(System.lineSeparator());
        stringBuilder.append(secret).append(System.lineSeparator());
        stringBuilder.append("GetTest");
        return stringBuilder.toString();
    }
}
