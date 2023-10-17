package ru.zuykin.mandarinegroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.zuykin.mandarinegroup.entity.Level;
import ru.zuykin.mandarinegroup.repository.LevelRepository;
import ru.zuykin.mandarinegroup.service.UserService;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/levels")
public class LevelController {

    private final LevelRepository levelRepository;
    @Autowired
    private UserService userService;
    private Level currentLevel;

    @Autowired
    public LevelController(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    @GetMapping
    public List<Level> getAllLevels() {
        return levelRepository.findByUserId(userService.getCurrentUser().getId());
    }

    @PostMapping("/update")
    public void updateLevels(@RequestBody List<Level> updatedLevels) {
        // Получите текущие уровни подписок из базы данных
        List<Level> currentLevels = levelRepository.findByUserId(userService.getCurrentUser().getId());
        for (Level updatedLevel : updatedLevels) {
            updatedLevel.setUser(userService.getCurrentUser());
        }
        System.out.println("Received updatedLevels: " + updatedLevels);

        if (currentLevels.isEmpty()) {
            for (Level updatedLevel : updatedLevels) {
                System.out.println("creating new levels");
                // Уровень не имеет ID, значит, он новый и должен быть создан
                Level newlevel = new Level(updatedLevel.getName(), updatedLevel.getDescription(), updatedLevel.getPrice(), userService.getCurrentUser());
                levelRepository.save(newlevel);
            }
            return;
        }

        // Пройдитесь по всем текущим уровням и проверьте, должны ли они быть удалены
        Iterator<Level> iterator = currentLevels.iterator();
        while (iterator.hasNext()) {
            Level currentLevel = iterator.next();
            boolean levelExistsInUpdatedData = false;

            for (Level updatedLevel : updatedLevels) {
                System.out.println("id current: " + currentLevel.getId());
                System.out.println("id updated: " + updatedLevel.getId());


                if (currentLevel.getId() != 0L && currentLevel.getId() == updatedLevel.getId()) {
                    System.out.println("adding new levels");
                    levelExistsInUpdatedData = true;

                    // Обновите свойства текущего уровня данными из updatedLevel
                    currentLevel.setName(updatedLevel.getName());
                    currentLevel.setDescription(updatedLevel.getDescription());
                    currentLevel.setPrice(updatedLevel.getPrice());
                    currentLevel.setUser(userService.getCurrentUser());

                    // Сохраните обновленный уровень
                    levelRepository.save(currentLevel);
                    iterator.remove(); // Удаляем уровень из списка, чтобы он не был удален
                    break;
                }
            }

            // Если уровень не найден в updatedLevels, удалите его
            if (!levelExistsInUpdatedData) {
                System.out.println("deleting levels");
                levelRepository.delete(currentLevel);
                iterator.remove(); // Удаляем уровень из списка
            }
        }

        // Теперь обработайте новые уровни
        for (Level updatedLevel : updatedLevels) {
            if (updatedLevel.getId() != 0) {
                System.out.println("updating levels");
                // Уровень не имеет ID, значит, он новый и должен быть создан
                levelRepository.save(updatedLevel);
            }
        }
    }

    @GetMapping("/view")
    public List<Level> levelView(@RequestParam(name = "userId") Long userId){
        List<Level> subscriptions = levelRepository.findByUserId(userId);
        return subscriptions;
    }

    @GetMapping("/{levelId}/cost")
    public ResponseEntity<Integer> getLevelCost(@PathVariable Long levelId) {
        Optional<Level> levelOptional = levelRepository.findById(levelId);

        if (levelOptional.isPresent()) {
            int price = levelOptional.get().getPrice();
            return ResponseEntity.ok(price);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
