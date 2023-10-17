package ru.zuykin.mandarinegroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.zuykin.mandarinegroup.entity.Level;

import java.util.List;
import java.util.Optional;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {
    @Query("SELECT l FROM Level l WHERE l.user.id = :userId")
    List<Level> findByUserId(Long userId);

    Optional<Level> findById(Long levelId);
}
