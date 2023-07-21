package discord.bot.listener;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if(!event.getAuthor().isBot()){
            String author = event.getAuthor().getName();
            event.getChannel().sendMessage(author + " Mensagem recebida!").queue();
        }
    }
}
