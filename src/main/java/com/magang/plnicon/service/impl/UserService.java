package com.magang.plnicon.service.impl;

import com.magang.plnicon.entity.User;
import com.magang.plnicon.repository.UserRepository;
import com.magang.plnicon.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService implements IUserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User findById(int userId) {
        return userRepository.findById(userId);
    }


//    @Override
//    public User updateUser(Integer userId, User userDetails) {
//        User existingUser = userRepository.findById(userId).orElse(null);
//        if (existingUser != null) {
//            BeanUtils.copyProperties(userDetails, existingUser, "id");
//            return userRepository.save(existingUser);
//        }
//        return null;
//    }
}


