package me.ayansaiyad.listener;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Messages extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        String message = event.getMessage().getContentRaw();
        String user = event.getAuthor().getAsTag();
        String channel = event.getChannel().getAsMention();

        if (!user.equals("momonkey#0020") && channel.equals("1086807254549942322")) {
            event.getMessage().delete().queue();
            event.getChannel().sendMessage("You are not allowed to send messages in this channel.").queue();
        }

        event.getGuild().getTextChannelById("1086533140555776000")
                .sendMessage(channel + " - **"+user.split("#")[0] +"**: _"+message + "_").queue();
    }
}
