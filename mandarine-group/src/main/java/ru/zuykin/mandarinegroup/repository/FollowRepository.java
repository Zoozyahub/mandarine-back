package ru.zuykin.mandarinegroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.zuykin.mandarinegroup.entity.Follow;
import ru.zuykin.mandarinegroup.entity.User;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    boolean existsByFollowerIdAndFollowingId(Long followerId, Long followingId);
    void deleteByFollowerIdAndFollowingId(Long followerId, Long followingId);

    @Query("SELECT f.following FROM Follow f WHERE f.follower.id = :followerId")
    List<User> findAllFollowingUsersByFollowerId(Long followerId);
}
