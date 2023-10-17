package ru.zuykin.mandarinegroup.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.zuykin.mandarinegroup.dto.PostDto;
import ru.zuykin.mandarinegroup.entity.Level;
import ru.zuykin.mandarinegroup.entity.Post;
import ru.zuykin.mandarinegroup.repository.LevelRepository;
import ru.zuykin.mandarinegroup.repository.PostRepository;
import ru.zuykin.mandarinegroup.service.PostService;
import ru.zuykin.mandarinegroup.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;
    @Autowired
    private UserService userService;
    PostRepository postRepository;
    @Autowired
    LevelRepository levelRepository;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@RequestBody PostDto post) {
        System.out.println("Current post " + post);
        Post newpost = new Post(post.getContent(), post.getTime(), post.getLevel(), userService.getCurrentUser());
        Post createdPost = postService.createPost(newpost);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @GetMapping("/allposts")
    public List<PostDto> getAllPostsByUserId(@RequestParam(name = "userId") Long userId) {
        List<Post> posts = postService.getAllPostsByUserId(userId);
        List<PostDto> postDtos = new ArrayList<>();
        for (Post post : posts) {
            PostDto postDto = new PostDto();
            postDto.setId(post.getId());
            postDto.setContent(post.getContent());
            postDto.setTime(post.getTime());
            postDto.setLevel(post.getLevel());
            postDtos.add(postDto);
        }
        return postDtos;
    }

    @GetMapping("/userSubscriptions")
    public List<PostDto> getUserSubscriptionPosts(@RequestParam(name = "userId") Long userId) {
        // Получите пользователя по userId (например, из базы данных)

        // Используйте сервисный класс для получения списка постов
        List<Post> posts = postService.getPostsByUserSubscriptions(userId);
        List<PostDto> postDtos = new ArrayList<>();
        for (Post post : posts) {
            PostDto postDto = new PostDto();
            postDto.setId(post.getId());
            postDto.setContent(post.getContent());
            postDto.setTime(post.getTime());
            postDto.setLevel(post.getLevel());
            postDto.setUser(post.getUser());
            postDtos.add(postDto);
        }

        return postDtos;
    }

}
