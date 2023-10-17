package ru.zuykin.mandarinegroup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.zuykin.mandarinegroup.controller", "ru.zuykin.mandarinegroup.config" , "ru.zuykin.mandarinegroup.repository", "ru.zuykin.mandarinegroup.etc", "ru.zuykin.mandarinegroup.entity"})
public class MandarineGroupApplication {

    public static void main(String[] args) {
        SpringApplication.run(MandarineGroupApplication.class, args);
    }

}
