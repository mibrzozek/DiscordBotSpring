package com.DBSpring.DiscordBotSpring.repository;

import com.DBSpring.DiscordBotSpring.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String>
{
    Optional<User> findUserById(String id);

}
