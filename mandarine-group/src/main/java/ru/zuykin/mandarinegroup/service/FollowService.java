package ru.zuykin.mandarinegroup.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import ru.zuykin.mandarinegroup.entity.Follow;
import ru.zuykin.mandarinegroup.entity.User;
import ru.zuykin.mandarinegroup.repository.FollowRepository;
import ru.zuykin.mandarinegroup.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FollowService {
    private FollowRepository followRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public FollowService(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

    public boolean isFollowing(Long followerId, Long followingId) {
        // Реализация проверки наличия записи в базе данных
        return followRepository.existsByFollowerIdAndFollowingId(followerId, followingId);
    }

    public void unfollow(Long followerId, Long followingId) {
        // Реализация удаления записи из базы данных
        System.out.println("unfollow by " + followerId);
        followRepository.deleteByFollowerIdAndFollowingId(followerId, followingId);
    }

    public void follow(Long followerId, Long followingId) {
        // Найти пользователя, который подписывается (follower)
        User follower = userRepository.findById(followerId).orElseThrow(() -> new EntityNotFoundException("User not found"));

        // Найти пользователя, на которого подписываются (following)
        User following = userRepository.findById(followingId).orElseThrow(() -> new EntityNotFoundException("User not found"));

        // Создать объект Follow и установить связи с пользователями
        Follow follow = new Follow();
        follow.setFollower(follower);
        follow.setFollowing(following);

        // Сохранить запись в базе данных
        followRepository.save(follow);
    }

    public List<User> getAllFollowsForUser(Long followerId) {
        return followRepository.findAllFollowingUsersByFollowerId(followerId);
    }
}
