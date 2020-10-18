package org.sobotics.chatexchange.chat.event;

import org.sobotics.chatexchange.chat.Room;

import com.google.gson.JsonElement;

/**
 * Holds the data for a deleted message event.
 * @author Tunaki
 */
public class MessageDeletedEvent extends MessageEvent {

    MessageDeletedEvent(JsonElement jsonElement, Room room) {
        super(jsonElement, room);
    }

}
