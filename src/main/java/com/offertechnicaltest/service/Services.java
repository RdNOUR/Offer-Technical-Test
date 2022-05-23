package com.offertechnicaltest.service;


import com.offertechnicaltest.domain.User;

import java.util.List;

public interface Services {
    public void registerUser(User user);
    public List<User> getUsers();
}