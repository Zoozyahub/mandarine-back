package ru.zuykin.mandarinegroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.zuykin.mandarinegroup.entity.Level;
import ru.zuykin.mandarinegroup.entity.Subscribe;

import java.util.List;

public interface SubscribeRepository extends JpaRepository<Subscribe, Long> {
    boolean existsBySubscriberIdAndLevelId(Long subscriberId, Long levelId);
    @Query("SELECT s.level FROM Subscribe s WHERE s.subscriber.id = :userId")
    List<Level> findAllLevelsByUserId(@Param("userId") Long userId);
}
