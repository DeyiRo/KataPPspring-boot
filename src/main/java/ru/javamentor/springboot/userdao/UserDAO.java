package ru.javamentor.springboot.userdao;

import ru.javamentor.springboot.model.User;

import java.util.List;

public interface UserDAO {


    void saveUser(User user);

    List<User> getAllUsers();

    User getUserById(long id);

    void updateUserById(long id, User user);

    void deleteUserById(long id);


}
