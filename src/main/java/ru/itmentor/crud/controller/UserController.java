package ru.itmentor.crud.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itmentor.crud.dto.UserDto;

@RequestMapping("/users")
public interface UserController {

    @GetMapping
    String getAllUsers(Model model);

    @PostMapping
    String saveUser(@ModelAttribute("userDto") UserDto userDto);

    @DeleteMapping
    String deleteUser(@RequestParam("id") Long userId);

    @PutMapping
    String updateUser(@RequestParam("id") Long userId, @ModelAttribute("user") UserDto userDto);

    @GetMapping("/{id}")
    String getUserById(@PathVariable Long id, Model model);


}