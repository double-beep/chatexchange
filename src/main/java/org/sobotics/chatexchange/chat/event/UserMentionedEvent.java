package org.sobotics.chatexchange.chat.event;

import org.sobotics.chatexchange.chat.Room;

import com.google.gson.JsonElement;

/**
 * Holds the data for a mention message event.
 * @author Tunaki
 */
public class UserMentionedEvent extends PingMessageEvent {

    UserMentionedEvent(JsonElement jsonElement, Room room) {
        super(jsonElement, room);
    }

}
