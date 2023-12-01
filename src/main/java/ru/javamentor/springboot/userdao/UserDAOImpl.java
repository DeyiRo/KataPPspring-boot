package ru.javamentor.springboot.userdao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import ru.javamentor.springboot.model.User;

import java.util.List;

@Component

public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManagerBean;


    @Override
    public void saveUser(User user) {
        entityManagerBean.persist(user);
        entityManagerBean.flush();
    }

    @Override
    public List<User> getAllUsers() {
        return entityManagerBean.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User findUserById(long id) {
        return entityManagerBean.find(User.class, id);

    }

    @Override
    public void updateUserById(long id, User user) {
        User toUpdate = findUserById(id);
        toUpdate.setName(user.getName());
        toUpdate.setProfession(user.getProfession());
        entityManagerBean.merge(toUpdate);
        entityManagerBean.flush();

    }

    @Override
    public void deleteUserById(long id) {
        entityManagerBean.remove(findUserById(id));
        entityManagerBean.flush();
    }

}
