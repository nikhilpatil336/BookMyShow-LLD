package com.example.BookMyShowBackend.Repositories.InMemoryRepositories;

import com.example.BookMyShowBackend.Model.User;
import com.example.BookMyShowBackend.Repositories.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class InMemoryUserRepository implements UserRepository {

    Map<Long, User> userMap = new HashMap<>();
    @Override
    public User saveUser(User user) {
        userMap.put(user.getId(), user);
        return userMap.get(user.getId());
    }
}
