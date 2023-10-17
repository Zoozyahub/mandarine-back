package ru.zuykin.mandarinegroup.etc;

import org.springframework.stereotype.Component;
import ru.zuykin.mandarinegroup.entity.User;

@Component
public class AppContext {

    private static ThreadLocal<User> currentUser = new ThreadLocal<>();

    public static void setCurrentUser(User user) {
        currentUser.set(user);
    }

    public static User getCurrentUser() {
        return currentUser.get();
    }

    public static void clearCurrentUser() {
        currentUser.remove();
    }
}

