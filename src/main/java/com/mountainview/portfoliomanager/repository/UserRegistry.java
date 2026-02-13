package com.mountainview.portfoliomanager.repository;

import com.mountainview.portfoliomanager.model.Investment;
import com.mountainview.portfoliomanager.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.UUID;

public class UserRegistry {

    private static final Logger logger = LoggerFactory.getLogger(UserRegistry.class);
    private static final HashMap<UUID, User> users = new HashMap<>();

    // Factory-like method to create + register user safely
    public static User createAndRegisterUser(String name, String email) {
        UUID newUserId = UUID.randomUUID(); // thread-safe unique UUID
        User user = new User(name, email, newUserId);
        users.put(newUserId, user);

        logger.info("Created and Registered new user with userId:{}", newUserId);
        return user;
    }

    public static User getUserById(UUID userId) {
        return users.get(userId);
    }

}
