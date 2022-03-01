package com.DBSpring.DiscordBotSpring.listeners;

import com.DBSpring.DiscordBotSpring.entities.User;
import com.DBSpring.DiscordBotSpring.exceptions.UserExistsException;
import com.DBSpring.DiscordBotSpring.services.UserService;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserListenerImp implements UserListener
{
    @Autowired
    private UserService userService;
    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent)
    {
        if(messageCreateEvent.getMessageContent().startsWith(".user"))
        {
            User user;
            try
            {
                user = userService.createUser(messageCreateEvent.getMessageAuthor().getIdAsString(), messageCreateEvent.getMessageAuthor().getDisplayName());
            }
            catch (UserExistsException e)
            {
                messageCreateEvent.getChannel().sendMessage(e.getMessage());
                return;
            }

            messageCreateEvent.getChannel().sendMessage("User has been created for " + messageCreateEvent.getMessageAuthor());
        }
    }
}
