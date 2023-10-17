package ru.zuykin.mandarinegroup.service;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zuykin.mandarinegroup.entity.User;
import ru.zuykin.mandarinegroup.etc.AppContext;
import ru.zuykin.mandarinegroup.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    private User currentUser;
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean validateLogin(String username, String password) {
        // Проверить наличие пользователя в базе данных
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            // Сравнить пароль с паролем пользователя из базы данных
            return user.getPassword().equals(password);
        }
        return false;
    }

    public void registerUser(String username, String password, String email) {
        // Создать нового пользователя
        User user = new User(username, password, email);
        // Сохранить пользователя в базе данных
        userRepository.save(user);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElse(null); // Вернуть null, если пользователь не найден
    }

    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.orElse(null);
    }
}

