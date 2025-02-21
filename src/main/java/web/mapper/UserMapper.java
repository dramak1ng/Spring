package web.mapper;

import org.springframework.stereotype.Component;
import web.dto.UserDto;
import web.model.User;
@Component
public class UserMapper {
    public User toEntity(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        return user;
    }
}
