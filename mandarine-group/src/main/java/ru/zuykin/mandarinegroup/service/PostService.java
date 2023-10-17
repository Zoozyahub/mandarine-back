package ru.zuykin.mandarinegroup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import ru.zuykin.mandarinegroup.entity.Level;
import ru.zuykin.mandarinegroup.entity.Post;
import ru.zuykin.mandarinegroup.entity.User;
import ru.zuykin.mandarinegroup.repository.PostRepository;
import ru.zuykin.mandarinegroup.repository.SubscribeRepository;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    @Autowired
    SubscribeRepository subscribeRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public List<Post> getAllPostsByUserId(@RequestParam(name = "userId") Long userId){
        List<Post> posts = postRepository.findByUserId(userId);
        return posts;
    }

    public List<Post> getPostsByUserSubscriptions(Long userId) {
        // Получите список уровней подписок пользователя (например, из базы данных)
        List<Level> userSubscriptions = subscribeRepository.findAllLevelsByUserId(userId);

        // Используйте репозиторий для получения постов по уровням подписок пользователя
        return postRepository.findByLevelIn(userSubscriptions);
    }
    // Другие методы для работы с постами, если необходимо
}
