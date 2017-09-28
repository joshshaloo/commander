package io.shaloo.commander.events;

import org.springframework.context.ApplicationEvent;

import java.util.Date;

public abstract class Event extends ApplicationEvent {

    private Date completedAt;

    public Event(Object source, Date completedAt) {
        super(source);
        this.completedAt = completedAt;
    }

    public Date getCompletedAt() {
        return completedAt;
    }

    public String getName() {
        return getClass().getSimpleName();
    }
}
