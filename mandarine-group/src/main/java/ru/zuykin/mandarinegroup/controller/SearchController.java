package ru.zuykin.mandarinegroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.zuykin.mandarinegroup.entity.User;
import ru.zuykin.mandarinegroup.repository.UserRepository;

import java.util.List;

@RestController
public class SearchController {
    @Autowired
    UserRepository userRepository;
    @GetMapping("api/search")
    public List<User> searchAuthors(@RequestParam("query") String query){
        List<User> foundUsers = userRepository.findByAuthorNameContaining(query);
        return foundUsers;
    }
}
