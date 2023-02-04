package web.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsersList() {
        TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
        List<User> allUsers = query.getResultList();
        return allUsers;
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(int id, User updateUser) {

        User userToBeUpdate = getUserById(id);
        userToBeUpdate.setName(updateUser.getName());
        userToBeUpdate.setLastName(updateUser.getLastName());
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(getUserById(id));
    }

}
