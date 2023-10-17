package ru.zuykin.mandarinegroup.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import ru.zuykin.mandarinegroup.entity.Level;
import ru.zuykin.mandarinegroup.entity.User;

public class PostDto {

    private long id;
    private String content;
    private String time;
    private Level level;
    private User user;

    public PostDto() {
    }

    public PostDto(long id, String content, String time, Level level) {
        this.id = id;
        this.content = content;
        this.time = time;
        this.level = level;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
