package org.sobotics.chatexchange.chat.event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.sobotics.chatexchange.chat.Room;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Utility class to operate on events.
 * @author Tunaki
 */
public final class Events {

    private Events() { }

    /**
     * Transforms the raw chat events to a list of event instances, with their corresponding data.
     * @param events Raw chat events, as returned the the StackExchange chat websockets.
     * @param room Room to return events from.
     * @return List of events with their data.
     */
    public static List<Event> fromJsonData(JsonArray events, Room room) {
        // kicked?
        if (events.size() == 2 && jsonObjects(events).anyMatch(o -> getEventType(o) == 4) && jsonObjects(events).anyMatch(o -> getEventType(o) == 15)) {
            return new ArrayList<>(Arrays.asList(new KickedEvent(events, room)));
        }
        // TODO: handle Feeds (user_id = -2)
        return jsonObjects(events)
                .filter(object -> (!object.has("user_id") || object.get("user_id").getAsLong() > 0) && object.get("room_id").getAsInt() == room.getRoomId())
                .map(object -> {
                    switch (getEventType(object)) {
                        case 1: return new MessagePostedEvent(object, room);
                        case 2: return new MessageEditedEvent(object, room);
                        case 3: return new UserEnteredEvent(object, room);
                        case 4: return new UserLeftEvent(object, room);
                        case 6: return new MessageStarredEvent(object, room);
                        case 10: return new MessageDeletedEvent(object, room);
                        case 8: return new UserMentionedEvent(object, room);
                        case 18: return new MessageReplyEvent(object, room);
                        default:
                            return null;
                    }
                }).filter(Objects::nonNull).collect(Collectors.toList());
    }

    private static Stream<JsonObject> jsonObjects(JsonArray array) {
        return StreamSupport.stream(array.spliterator(), false).map(JsonElement::getAsJsonObject);
    }

    private static int getEventType(JsonObject object) {
        return object.get("event_type").getAsInt();
    }

}
