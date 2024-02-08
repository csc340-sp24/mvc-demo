package com.csc340.mvcdemo.controller;

import com.csc340.mvcdemo.model.User;
import com.csc340.mvcdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author csc340-sp24
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping({"/all", "/", ""})
    public String getAllUsers(Model model) {
        model.addAttribute("userList", service.getAllUsers());
        return "user/user-list";
    }

    @GetMapping("/id={id}")
    public String getUser(@PathVariable int id, Model model) {
        model.addAttribute("user", service.getUserById(id));
        return "user/user-detail";
    }

    @PostMapping("/create")
    public String createUser(User user) {
        service.createUser(user);
        return "redirect:/users/all";
    }

    @GetMapping("/delete/id={id}")
    public String deleteUser(@PathVariable int id, Model model) {
        service.deleteUser(id);
        return "redirect:/users/all";
    }

}
