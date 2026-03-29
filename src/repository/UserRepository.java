package repository;

import model.User;
import java.util.*;

public class UserRepository {
    private List<User> users = new ArrayList<>();

    public void save(User u) {
        users.add(u);
    }

    public List<User> findAll() {
        return users;
    }
}