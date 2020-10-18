package org.sobotics.chatexchange.chat.event;

import org.sobotics.chatexchange.chat.Room;

import com.google.gson.JsonElement;

/**
 * Represents the event where a user entered the chat room. This event can only be raised if that user wasn't already in the room
 * (meaning the user previously left it or they never entered).
 * @author Tunaki
 */
public class UserEnteredEvent extends Event {

    UserEnteredEvent(JsonElement jsonElement, Room room) {
        super(jsonElement, room);
    }

}
