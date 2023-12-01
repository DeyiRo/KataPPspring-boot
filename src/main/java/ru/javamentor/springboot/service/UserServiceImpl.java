package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.dao.UserDAO;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;
@Component
public class UserService implements UserServiceI {
    @Autowired
    private UserDAO userDao;

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User findUserById(long id) {
        return findUserById(id);
    }

    @Override
    @Transactional
    public void updateUserById(long id, User user) {
        userDao.updateUserById(id, user);
    }

    @Override
    @Transactional
    public void deleteUserById(long id) {
        userDao.deleteUserById(id);
    }
}
