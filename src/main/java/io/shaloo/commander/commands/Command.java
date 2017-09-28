package io.shaloo.commander.commands;

import io.shaloo.commander.events.Event;
import io.shaloo.commander.events.EventGenerator;

import java.util.List;

public abstract class Command {

    private EventGenerator eventGenerator;

    public Command() {
        this.eventGenerator = new EventGenerator();
    }

    public void raise(Event event) {
        eventGenerator.raise(event);
    }

    public List<Event> release() {
        return eventGenerator.release();
    }

    public List<Event> getReleasedEvents() {
        return eventGenerator.getReleasedEvents();
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }
}