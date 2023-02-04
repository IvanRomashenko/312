package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private UserDAO userDAO;

    public UserServiceImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    @Transactional(readOnly = true)
    public List<User> getUsersList() {
        return userDAO.getUsersList();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(int id, User updateUser) {
        userDAO.updateUser(id, updateUser);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }
}
