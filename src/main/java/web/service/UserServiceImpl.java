package web.service;

import web.dto.UserDto;
import web.mapper.UserMapper;
import org.springframework.stereotype.Service;
import web.exception.UserNotFoundExp;
import web.model.User;
import web.repository.UserRepository;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    private final UserRepository userRepository;



    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public void getUserById(int id) {

        findUserById(id);
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundExp(id));

    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);

    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);

    }

    @Override

    public void updateUser(int id, UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user.setId(findUserById(id).getId());
        userRepository.save(user);


    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    private User findUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundExp(id));
    }
}
