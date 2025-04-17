package com.example.brokagedemo.service;

import com.example.brokagedemo.model.dto.userservice.UserResponse;
import com.example.brokagedemo.model.entity.User;
import com.example.brokagedemo.model.mappers.UserMapper;
import com.example.brokagedemo.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserResponse getUserByMail(String mail) {
        Optional<User> user = userRepository.getUserByCustomerMail(mail);
        return user.map(userMapper::toUserResponse)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

    }

    public UserResponse getUserById(Long id) {
        Optional<User> user = userRepository.getUserByCustomer_Id(id);
        return user.map(userMapper::toUserResponse)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    public User getUserByUsername(String username) {
        Optional<User> user = userRepository.getUserByUsername(username);
        return user.orElse(null);
    }

    public boolean isUserExist(String username) {
        return userRepository.existsUserByUsername(username);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
