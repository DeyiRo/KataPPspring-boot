package ru.javamentor.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.springboot.model.User;
import ru.javamentor.springboot.userdao.UserDAO;


@Controller
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping()
    public String getUsersList(Model model) {
        model.addAttribute("usersList", userDAO.getAllUsers());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        userDAO.saveUser(user);
        return "redirect:users";
    }

    @GetMapping("/edit")
    public String editUser(Model model, @RequestParam("id") long id) {
        User user = userDAO.getUserById(id);
        model.addAttribute("editUser", user);
        return "edit";
    }

    @PostMapping("/edit-user")
    public String updateUser(@ModelAttribute("editUser") User editUser) {
        userDAO.updateUserById(editUser.getId(), editUser);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String deleteUser(Model model, @RequestParam("id") long id) {
        User user = userDAO.getUserById(id);
        model.addAttribute("deleteUser", user);
        return "delete";
    }

    @PostMapping("/delete-user")
    public String removeUser(@ModelAttribute("deleteUser") User deleteUser) {
        userDAO.deleteUserById(deleteUser.getId());
        return "redirect:/users";
    }
}