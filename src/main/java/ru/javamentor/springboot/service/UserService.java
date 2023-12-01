package ru.javamentor.springboot.service;



import ru.javamentor.springboot.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    List<User> getAllUsers();

    User findUserById(long id);

    void updateUserById(long id, User user);

    void deleteUserById(long id);
}
