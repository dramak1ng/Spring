package ru.itmentor.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itmentor.crud.dto.UserDto;
import ru.itmentor.crud.service.UserService;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller

public class UserControllerImpl implements UserController {

    private static final String REDIRECT_URL = "redirect:/users";

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }


    @Override
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("userDto", new UserDto());
        return "users/list";
    }



    @Override
    public String saveUser(@ModelAttribute("userDto") UserDto userDto) {
        userService.saveUser(userDto);
        return REDIRECT_URL;
    }

    @Override
    public String deleteUser(@RequestParam("id") Long userId) {
        userService.deleteUserById(userId);
        return REDIRECT_URL;
    }

    @Override
    public String updateUser(@RequestParam("id") Long userId, @ModelAttribute("user") UserDto userDto) {
        userService.updateUser(userId, userDto);
        return REDIRECT_URL;

    }

    @Override
    public String getUserById(@PathVariable Long id, Model model) {
        userService.getUserById(id);
        return REDIRECT_URL;
    }

}
