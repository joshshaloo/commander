package io.shaloo.commander.events;

import java.util.ArrayList;
import java.util.List;

public class EventGenerator {
    private List<Event> pendingEvents;
    private List<Event> releasedEvents;

    public EventGenerator() {
        this.pendingEvents = new ArrayList<Event>();
        this.releasedEvents = new ArrayList<Event>();
    }

    public void raise(Event event) {
        this.pendingEvents.add(event);
    }

    public List<Event> release() {
        List<Event> releasedEvents = this.pendingEvents;
        this.releasedEvents.addAll(releasedEvents);
        this.pendingEvents = new ArrayList<Event>();
        return releasedEvents;
    }

    public List<Event> getReleasedEvents() {
        return releasedEvents;
    }
}