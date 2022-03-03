package com.DBSpring.DiscordBotSpring.services;

import com.DBSpring.DiscordBotSpring.entities.User;
import com.DBSpring.DiscordBotSpring.exceptions.UserExistsException;
import org.springframework.stereotype.Service;

@Service
public interface UserService
{
    User createUser(String is, String name) throws UserExistsException;
}
