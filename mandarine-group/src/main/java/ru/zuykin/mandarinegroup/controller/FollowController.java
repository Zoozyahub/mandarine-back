package ru.zuykin.mandarinegroup.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.zuykin.mandarinegroup.entity.Follow;
import ru.zuykin.mandarinegroup.entity.User;
import ru.zuykin.mandarinegroup.service.FollowService;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/follow")
public class FollowController {
    @Autowired
    FollowService followService;

    @PostMapping
    public void follow(@RequestBody Map<String, Long> body){
        Long followerId = body.get("followerId");
        Long followingId = body.get("followingId");

        followService.follow(followerId, followingId);
    }

    @Transactional
    @DeleteMapping
    public void unfollow(@RequestBody Map<String, Long> body){
        Long followerId = body.get("followerId");
        Long followingId = body.get("followingId");
        if (followService.isFollowing(followerId, followingId)) {
            // Если существует, удаляем ее
            followService.unfollow(followerId, followingId);
        }
    }

    @GetMapping("/allFollows")
    public List<User> allMyFollows(@RequestParam("userId") Long userId){
        // Здесь реализуйте логику для получения списка пользователей, на которых пользователь с userId подписан
        List<User> allMyFollows = followService.getAllFollowsForUser(userId);
        return allMyFollows;
    }

    @GetMapping("/isFollowing")
    public boolean isFollowing(@RequestParam("followerId") Long followerId, @RequestParam("followingId") Long followingId) {
        return followService.isFollowing(followerId, followingId);
    }
}
