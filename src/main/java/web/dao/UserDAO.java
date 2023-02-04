package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getUsersList();

    void addUser(User user);

    User getUserById(int id);

    void updateUser(int id, User updateUser);

    void deleteUser(int id);
}

