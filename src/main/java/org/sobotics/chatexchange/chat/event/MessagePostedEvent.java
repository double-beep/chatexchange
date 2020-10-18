package org.sobotics.chatexchange.chat.event;

import org.sobotics.chatexchange.chat.Room;

import com.google.gson.JsonElement;

/**
 * Holds the data for an post message event.
 * @author Tunaki
 */
public class MessagePostedEvent extends MessageEvent {

    MessagePostedEvent(JsonElement jsonElement, Room room) {
        super(jsonElement, room);
    }

}
