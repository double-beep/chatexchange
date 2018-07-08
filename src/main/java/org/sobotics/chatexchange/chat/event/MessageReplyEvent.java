package org.sobotics.chatexchange.chat.event;

import org.sobotics.chatexchange.chat.Room;

import com.google.gson.JsonElement;

/**
 * Holds the data for an reply message event.
 * @author Tunaki
 */
public class MessageReplyEvent extends PingMessageEvent {

	MessageReplyEvent(JsonElement jsonElement, Room room) {
		super(jsonElement, room);
	}

}
