package ru.cloud.controller;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class FacadeController {
    @GetMapping
    public String getFacade() {
        log.info("GetFacade");
        return "GetFacade";
    }
}
