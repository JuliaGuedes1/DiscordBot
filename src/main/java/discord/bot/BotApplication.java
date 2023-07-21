package discord.bot;

import discord.bot.listener.MessageListener;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BotApplication {

	public static void main(String[] args) {
		SpringApplication.run(BotApplication.class, args);

		JDABuilder builder = JDABuilder.createDefault("");

		// Disable parts of the cache
		builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
		// Enable the bulk delete event
		builder.setBulkDeleteSplittingEnabled(false);
		// Set activity (like "playing Something")
		builder.setActivity(Activity.listening("cutokn"));

		MessageListener messageListener = new MessageListener();
		builder.addEventListeners(messageListener);

		builder.build();

	}

}
