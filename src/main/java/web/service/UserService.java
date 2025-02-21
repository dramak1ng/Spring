package web.service;

import web.dto.UserDto;
import web.model.User;

import java.util.List;

public interface UserService {
    void getUserById(int id);
    void saveUser(User user);
    void deleteUserById(int id);
    void updateUser(int id, UserDto userDto);
    List<User> getAllUsers();

}
