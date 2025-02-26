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

        private final UserRepository userRepository;

        public UserServiceImpl(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        @Override
        public List<User> getAllUsers() {
            return userRepository.findAll();
        }

        @Override
        @Transactional
        public void saveUser(UserDto userDto) {
            User user = UserMapper.toEntity(userDto);
            userRepository.save(user);
        }

        @Override
        @Transactional
        public void updateUser(Long userId, UserDto userDto) {
            User user = findUserById(userId);
            user.setName(userDto.getName());
            user.setLastName(userDto.getLastName());
            userRepository.update(user);
        }

        @Override
        @Transactional
        public void deleteUserById(Long userId) {
            userRepository.delete(userId);
        }

    @Override
    public void getUserById(Long userId) {
        userRepository.getUserById(userId);
    }

    private User findUserById(Long userId) {
            return userRepository.getUserById(userId)
                    .orElseThrow(() -> new UserNotFoundException(userId));
        }

}