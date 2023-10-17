package ru.zuykin.mandarinegroup.response;

import ru.zuykin.mandarinegroup.entity.User;

public class LoginResponse {
    private String message;
    private User user;

    // геттеры и сеттеры

    public User getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

