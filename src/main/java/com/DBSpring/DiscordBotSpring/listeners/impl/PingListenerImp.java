package com.DBSpring.DiscordBotSpring.listeners.impl;

import com.DBSpring.DiscordBotSpring.listeners.PingListener;
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
            messageCreateEvent.getChannel().sendMessage("We may have progress 3!");
        }
    }
}
