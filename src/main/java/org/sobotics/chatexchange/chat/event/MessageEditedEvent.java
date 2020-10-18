package org.sobotics.chatexchange.chat.event;

import org.sobotics.chatexchange.chat.Room;

import com.google.gson.JsonElement;

/**
 * Holds the data for an edit message event.
 * @author Tunaki
 */
public class MessageEditedEvent extends MessageEvent {

    MessageEditedEvent(JsonElement jsonElement, Room room) {
        super(jsonElement, room);
    }

}
