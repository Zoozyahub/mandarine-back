package ru.zuykin.mandarinegroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.zuykin.mandarinegroup.dto.LoginRequest;
import ru.zuykin.mandarinegroup.dto.RegisterRequest;
import ru.zuykin.mandarinegroup.service.UserService;
import ru.zuykin.mandarinegroup.entity.User;
import ru.zuykin.mandarinegroup.response.LoginResponse;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    private User currentUser; // Добавьте это объявление переменной

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        if (userService.validateLogin(loginRequest.getUsername(), loginRequest.getPassword())) {
            User currentUser = userService.getUserByUsername(loginRequest.getUsername());

            // Установите текущего пользователя в UserService
            userService.setCurrentUser(currentUser);
            LoginResponse response = new LoginResponse();
            System.out.println(userService.getCurrentUser().getUsername() + " logged in");
            response.setMessage("Вход выполнен успешно");
            response.setUser(currentUser);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }


    @GetMapping("/logout")
    public ResponseEntity<String> logout() {
        System.out.println(userService.getCurrentUser().getUsername() + "logged out");
        userService.setCurrentUser(null); // Сброс значения поля currentUser при выходе
        return ResponseEntity.ok("Выход выполнен успешно");
    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        // Получите данные для регистрации из registerRequest
        // Создайте нового пользователя в базе данных с указанными данными

        userService.registerUser(registerRequest.getUsername(), registerRequest.getPassword(), registerRequest.getEmail());

        return ResponseEntity.ok("Регистрация выполнена успешно");
    }
}
