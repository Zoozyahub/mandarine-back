package ru.zuykin.mandarinegroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.zuykin.mandarinegroup.service.SubscribeService;

import java.util.Map;

@RestController
@RequestMapping("/api/subscribe")
public class SubscribeController {
    @Autowired
    SubscribeService subscribeService;

    @PostMapping
    public void subscribe(@RequestBody Map<String, Long> body){
        Long userId = body.get("userId");
        Long levelId = body.get("levelId");
        subscribeService.subscribe(userId, levelId);
    }

    @PostMapping("/exist")
    public boolean canView(@RequestBody Map<String, Long> body){
        Long userId = body.get("userId");
        Long levelId = body.get("levelId");
        return subscribeService.exist(userId, levelId);
    }
}
