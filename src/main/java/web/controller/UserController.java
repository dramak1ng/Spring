package web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dto.UserDto;

import web.model.User;
import web.service.UserService;



@Controller

public class UserController {


    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/user")
    public String  getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("user", new UserDto());
        return "user";
    }
    @PutMapping("/user/update")
    public void updateUser(int id,UserDto userDto) {
        userService.updateUser(id,userDto);


    }
    @GetMapping("/user/{id}/getUser")
    public void getUserById(@PathVariable int id, Model model) {
        userService.getUserById(id);
    }
    @PostMapping("/user/save")
    public void saveUser(User user){
        userService.saveUser(user);
    }
    @DeleteMapping("/user/delete")
    public void deleteUserById(int id){
        userService.deleteUserById(id);
    }
    @PutMapping("/user/{id}/updateUser")
    public void updateUserById( @PathVariable int id,UserDto userDto){
        userService.updateUser(id,userDto);
    }


}
