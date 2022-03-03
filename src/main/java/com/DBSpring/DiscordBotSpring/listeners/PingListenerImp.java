package com.DBSpring.DiscordBotSpring.listeners;

import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.stereotype.Component;

@Component
public class PingListenerImp implements PingListener
{
    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent)
    {
        if(messageCreateEvent.getMessageContent().equals(".ping"))
        {
            messageCreateEvent.getChannel().sendMessage("Pong!");
        }
        else if(messageCreateEvent.getMessageContent().equals(".ding"))
        {
            messageCreateEvent.getChannel().sendMessage("This is database testing 1!");
        }
    }
}
