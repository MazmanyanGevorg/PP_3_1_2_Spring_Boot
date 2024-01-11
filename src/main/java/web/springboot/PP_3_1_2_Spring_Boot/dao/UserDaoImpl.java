package web.springboot.PP_3_1_2_Spring_Boot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import web.springboot.PP_3_1_2_Spring_Boot.model.User;

import java.util.List;
import java.util.Objects;

@Component
public class UserDaoImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager
                .createQuery("SELECT u FROM users u", User.class)
                .getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        User userEdit = entityManager.find(User.class, user.getId());
        if (userEdit != null) {
            userEdit.setName(user.getName());
            userEdit.setSurname(user.getSurname());
            userEdit.setAge(user.getAge());
            userEdit.setLevel(user.getLevel());
            userEdit.setPoints(user.getPoints());
        }
        entityManager.merge(userEdit);
    }

    @Override
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public User getUserById(Long userId) {
        return getAllUsers()
                .stream().filter(user -> Objects.equals(user.getId(), userId))
                .findAny()
                .orElse(null);
    }
}
