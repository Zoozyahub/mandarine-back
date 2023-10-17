package ru.zuykin.mandarinegroup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.zuykin.mandarinegroup.repository.FollowRepository;
import ru.zuykin.mandarinegroup.repository.PostRepository;
import ru.zuykin.mandarinegroup.repository.SubscribeRepository;
import ru.zuykin.mandarinegroup.repository.UserRepository;
import ru.zuykin.mandarinegroup.service.FollowService;
import ru.zuykin.mandarinegroup.service.PostService;
import ru.zuykin.mandarinegroup.service.SubscribeService;
import ru.zuykin.mandarinegroup.service.UserService;

@Configuration
public class AppConfig {
    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserService(userRepository);
    }
    @Bean
    public PostService postService(PostRepository postRepository) {
        return new PostService(postRepository);
    }
    @Bean
    public FollowService followService(FollowRepository followRepository) {return new FollowService(followRepository);}
    @Bean
    public SubscribeService subscribeService(SubscribeRepository subscribeRepository) {return new SubscribeService(subscribeRepository);}

    // другие бины и конфигурация
}

