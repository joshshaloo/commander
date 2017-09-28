package io.shaloo.commander.events;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventDispatcher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    public void dispatch(List<Event> events) {
        for (Event event : events) {
            String actionName = event.getName();
            publisher.publishEvent(event);
        }
    }

    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }
}
