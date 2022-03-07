package com.DBSpring.DiscordBotSpring;

import com.DBSpring.DiscordBotSpring.listeners.PingListener;
import com.DBSpring.DiscordBotSpring.listeners.UserListener;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class DiscordBotSpringApplication
{
	@Autowired
	private Environment env;
	@Autowired
	private PingListener pingListener;
	@Autowired
	private UserListener userListener;

	public static void main(String[] args)
	{
		SpringApplication.run(DiscordBotSpringApplication.class, args);
	}
	@Bean
	@ConfigurationProperties(value = "discord-api")
	public DiscordApi discordApi()
	{
		String token = env.getProperty("TOKEN");
		DiscordApi  api= new DiscordApiBuilder().setToken(token)
				.setAllNonPrivilegedIntents()
				.login()
				.join();

		api.addMessageCreateListener(pingListener);
		api.addMessageCreateListener(userListener);

		return api;
	}
}
