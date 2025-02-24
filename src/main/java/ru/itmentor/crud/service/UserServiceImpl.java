package ru.itmentor.crud.service;


import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.itmentor.crud.dto.UserDto;
import ru.itmentor.crud.exception.UserNotFoundException;
import ru.itmentor.crud.mapper.UserMapper;
import ru.itmentor.crud.model.User;
import ru.itmentor.crud.repository.UserRepository;

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
    public void getUserById(long id) {
        findUserById(id);
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    @Transactional
    public void saveUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateUser(long id, UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user.setId(findUserById(id).getId());
        userRepository.save(user);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    private User findUserById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }
}