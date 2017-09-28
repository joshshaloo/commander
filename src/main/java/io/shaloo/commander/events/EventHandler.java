package io.shaloo.commander.events;

import io.shaloo.commander.exceptions.EventExecutionException;

public interface EventHandler<T extends Event> {
    void when(T event) throws EventExecutionException;
}
