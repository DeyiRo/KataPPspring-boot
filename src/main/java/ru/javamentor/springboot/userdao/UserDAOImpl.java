package ru.javamentor.springboot.userdao;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentor.springboot.model.User;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
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
        User toUpdate = getUserById(id);
        toUpdate.setName(user.getName());
        toUpdate.setProfession(user.getProfession());
        entityManagerBean.merge(toUpdate);
        entityManagerBean.flush();

    }

    @Override
    public void deleteUserById(long id) {
        entityManagerBean.remove(getUserById(id));
        entityManagerBean.flush();
    }

}
