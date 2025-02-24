package ru.itmentor.crud.mapper;

import ru.itmentor.crud.dto.UserDto;
import ru.itmentor.crud.model.User;


import org.springframework.stereotype.Component;
@Component
public class UserMapper {
    public User toEntity(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        return user;
    }
}