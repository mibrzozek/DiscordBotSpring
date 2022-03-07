package com.DBSpring.DiscordBotSpring.services;

import com.DBSpring.DiscordBotSpring.entities.User;
import com.DBSpring.DiscordBotSpring.exceptions.UserExistsException;

public interface UserService
{
    User createUser(String is, String name) throws UserExistsException;
}
