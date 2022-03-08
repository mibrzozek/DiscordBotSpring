package com.DBSpring.DiscordBotSpring.services.impl;

import com.DBSpring.DiscordBotSpring.entities.User;
import com.DBSpring.DiscordBotSpring.exceptions.UserExistsException;
import com.DBSpring.DiscordBotSpring.repository.UserRepository;

import com.DBSpring.DiscordBotSpring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserServiceImp implements UserService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(String id, String name) throws UserExistsException
    {
        Optional<User> userOpt = userRepository.findUserById(id);
        if(userOpt.isPresent())
        {
            throw new UserExistsException(id, name);
        }

        User user = new User(id, name);
        user = userRepository.save(user);
        return user;

    }
}
