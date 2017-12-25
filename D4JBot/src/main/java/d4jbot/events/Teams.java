package d4jbot.events;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import d4jbot.misc.MessageSender;
import d4jbots.enums.BotPrefix;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

public class Teams {
	
	private MessageSender ms;
	
	// default constructor
	public Teams() { }
	
	// constructor
	public Teams(MessageSender ms) {
		this.ms = ms;
	}
		
	@EventSubscriber
	public void onMessageReceivedEvent(MessageReceivedEvent e) {
		if(e.getMessage().getContent().startsWith(BotPrefix.BOT_PREFIX.getBotPrefix() + "teams")) {
			List<String> list = Arrays.asList(e.getMessage().getContent().split(" "));

			if(list.size() > 3) {
				Collections.shuffle(list);
				
				String team1 = "";
				String team2 = "";
				boolean teamSwitch = true;
				
				for(String s : list) {
					if(!s.equals(BotPrefix.BOT_PREFIX.getBotPrefix() + "teams")) {
						if(teamSwitch) team1 += s + " ";
						else team2 += s + " ";
						teamSwitch = !teamSwitch;
					}
				}
				
				ms.sendMessage(e.getChannel(), true, "Team 1: " + team1 + "\nTeam 2: " + team2);
			} else {
				ms.sendMessage(e.getChannel(), true, "$teams needs at least 3 following parameters / names.");
			}
		}
	}
}