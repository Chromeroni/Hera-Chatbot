package d4jbot.misc;

import d4jbot.constants.BotConstants;
import d4jbot.enums.BotSettings;
import d4jbot.enums.BoundChannel;
import d4jbot.enums.YoutubeSettings;
import sx.blah.discord.handle.obj.IGuild;

public class ProjectInitalizer {
	public ProjectInitalizer() {
	}
	
	public void initalizeProperties() {
		PropertiesHandler propHandler = new PropertiesHandler(BotConstants.SETTINGS_PROPERTY_LOCATION);
		propHandler.load();
		for (BotSettings value : BotSettings.values()) {
			if (propHandler.containsKey(value.getPropertyName())) {
				value.setPropertyValue(propHandler.getProperty(value.getPropertyName()));
			}
		}
	}
	
	public void initalizeBindings(IGuild iGuild) {
		PropertiesHandler propHandler = new PropertiesHandler(BotConstants.BINDING_PROPERTY_LOCATION);
		propHandler.load();
		for (BoundChannel value : BoundChannel.values()) {
			value.setBoundChannel(propHandler.containsKey(value.getPropertyName()) ? iGuild.getChannelByID(new Long(propHandler.getProperty(value.getPropertyName()))) : value.getBoundChannel());
		}
	}
	
	public void initializeYoutubeProperties() {
		PropertiesHandler propHandler = new PropertiesHandler(BotConstants.YOUTUBE_PROPERTY_LOCATION);
		propHandler.load();
		for (YoutubeSettings value : YoutubeSettings.values()) {
			if(propHandler.containsKey(value.getPropertyName())) {
				value.setPropertyValue(propHandler.getProperty(value.getPropertyName()));
			}
		}
	}
}