package ru.zuykin.mandarinegroup.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class ExampleController {

    @GetMapping("/data")
    public String getData() {
        return "Привет из контроллера!";
    }
}

