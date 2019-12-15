package hera.core.commands;

import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Guild;
import discord4j.core.object.entity.Member;
import discord4j.core.object.entity.MessageChannel;
import hera.core.HeraUtil;
import hera.core.music.HeraAudioManager;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.util.List;

public class NowPlaying {
	public static Mono<Void> execute(MessageCreateEvent event, Guild guild, Member member, MessageChannel channel, List<String> params) {
		return getNowPlayingString().flatMap(nowPlayingStringParts -> channel.createMessage(spec -> spec.setEmbed(embed -> {
			embed.setColor(Color.ORANGE);
			embed.setTitle(nowPlayingStringParts[0]);
			embed.setDescription(nowPlayingStringParts[1]);
		})))
		.then();
	}

	private static Mono<String[]> getNowPlayingString () {
		String title = "Now Playing";
		AudioTrack track = HeraAudioManager.getPlayer().getPlayingTrack();
		StringBuilder nowPlayingString = new StringBuilder();
		if (track != null) {
			nowPlayingString.append("Author: ");
			nowPlayingString.append(track.getInfo().author);
			nowPlayingString.append("\n[");
			nowPlayingString.append(track.getInfo().title);
			nowPlayingString.append("](");
			nowPlayingString.append(track.getInfo().uri);
			nowPlayingString.append(")\n\n`");
			nowPlayingString.append(HeraUtil.getFormattedTime(track.getPosition()));
			nowPlayingString.append("` **|**`");

			long tenPercent = track.getDuration() / 10;
			int percentagePosition = (int) (track.getPosition() / tenPercent);

			for (int i = 0; i < 10; i++) {
				if (i == percentagePosition) nowPlayingString.append("»»");
				else nowPlayingString.append("--");
			}

			nowPlayingString.append("`**|** `");
			nowPlayingString.append(HeraUtil.getFormattedTime(track.getDuration()));
			nowPlayingString.append("`");
		} else {
			nowPlayingString.append("No song is playing right now...");
		}

		return Mono.just(new String[] {title, nowPlayingString.toString()});
	}
}
