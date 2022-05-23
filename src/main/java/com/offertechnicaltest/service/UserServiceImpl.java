package com.offertechnicaltest.service;


import com.offertechnicaltest.domain.User;
import com.offertechnicaltest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


@Service
public class UserServiceImpl implements Services {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerUser(User user) {
            userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

}