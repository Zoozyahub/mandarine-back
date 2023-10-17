package ru.zuykin.mandarinegroup.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zuykin.mandarinegroup.entity.Level;
import ru.zuykin.mandarinegroup.entity.Subscribe;
import ru.zuykin.mandarinegroup.entity.User;
import ru.zuykin.mandarinegroup.repository.LevelRepository;
import ru.zuykin.mandarinegroup.repository.SubscribeRepository;
import ru.zuykin.mandarinegroup.repository.UserRepository;

@Service
public class SubscribeService {
    private final SubscribeRepository subscribeRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    LevelRepository levelRepository;

    @Autowired
    public SubscribeService(SubscribeRepository subscribeRepository) {
        this.subscribeRepository = subscribeRepository;
    }

    public void subscribe(Long userId, Long levelId){
        Subscribe sub = new Subscribe();
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
        Level level = levelRepository.findById(levelId).orElseThrow(() -> new EntityNotFoundException("User not found"));
        sub.setSubscriber(user);
        sub.setLevel(level);
        subscribeRepository.save(sub);
    }

    public boolean exist(Long userId, Long levelId){
        return subscribeRepository.existsBySubscriberIdAndLevelId(userId, levelId);
    }
}
