package ru.zuykin.mandarinegroup.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import ru.zuykin.mandarinegroup.dto.AuthorRequest;
import ru.zuykin.mandarinegroup.entity.User;
import ru.zuykin.mandarinegroup.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/current")
    public ResponseEntity<User> getCurrentUser() {
        User currentUser = userService.getCurrentUser();
        if (currentUser != null) {
            return ResponseEntity.ok(currentUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/author")
    public ResponseEntity<String> authorRegistration(@RequestBody AuthorRequest authorRequest) {
        User currentUser = userService.getCurrentUser();

        if (currentUser == null) {
            return ResponseEntity.notFound().build();
        }

        currentUser.setIs_author();
        currentUser.setAuthor_name(authorRequest.getAuthor_name());
        System.out.println(authorRequest.getAuthor_name());
        System.out.println("Received AuthorRequest: " + authorRequest.toString());
        currentUser.setAuthor_tags(authorRequest.getAuthor_tags());
        currentUser.setAuthor_description(authorRequest.getAuthor_description());
        currentUser.setAuthor_avatar(authorRequest.getAuthor_avatar());
        currentUser.setAuthor_header(authorRequest.getAuthor_header());
        currentUser.setQiwi_wallet(authorRequest.getQiwi_wallet());
        currentUser.setCard_number(authorRequest.getCard_number());
        currentUser.setCard_name(authorRequest.getCard_name());
        currentUser.setCard_date(authorRequest.getCard_date());
        currentUser.setCard_cvv(authorRequest.getCard_cvv());

        userService.saveUser(currentUser);

        return ResponseEntity.ok("User " + currentUser.getUsername() +"updated and set as author");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        System.out.println(userId);
        User user = userService.getUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

