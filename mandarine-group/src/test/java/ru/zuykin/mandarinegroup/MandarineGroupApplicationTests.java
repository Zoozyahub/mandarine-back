package ru.zuykin.mandarinegroup;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@ComponentScan(basePackages = {"ru.zuykin.mandarinegroup.controller", "ru.zuykin.mandarinegroup.config"})
class MandarineGroupApplicationTests {

    @Test
    void contextLoads() {
    }

}
