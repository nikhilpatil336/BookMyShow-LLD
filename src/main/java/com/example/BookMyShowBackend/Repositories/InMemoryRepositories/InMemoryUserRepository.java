package com.example.BookMyShowBackend.Repositories.InMemoryRepositories;

import com.example.BookMyShowBackend.Model.User;
import com.example.BookMyShowBackend.Repositories.UserRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository {

    Map<Long, User> userMap = new HashMap<>();
    @Override
    public User saveUser(User user) {
        User savedUser = userMap.put(user.getId(), user);
        return savedUser;
    }
}
