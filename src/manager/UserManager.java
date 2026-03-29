package manager;

import model.User;
import service.UserService;

import java.util.List;

public class UserManager {
    private final UserService userService;

    public UserManager(UserService userService) {
        this.userService = userService;
    }

    public void registerUser(User user) {
        userService.saveUser(user);
    }

    public List<User> getAllUsers() {
        return userService.getUsers();
    }
}
