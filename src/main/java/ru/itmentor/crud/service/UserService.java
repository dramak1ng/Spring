package ru.itmentor.crud.service;

import ru.itmentor.crud.dto.UserDto;
import ru.itmentor.crud.model.User;
import java.util.List;

public interface UserService {
    void getUserById(long id);
    void saveUser(UserDto userDto);
    void deleteUserById(long id);
    void updateUser(long id, UserDto userDto);
    List<User> getAllUsers();

}