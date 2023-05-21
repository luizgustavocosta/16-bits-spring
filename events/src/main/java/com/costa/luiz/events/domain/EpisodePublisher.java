package com.costa.luiz.events.domain;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class EpisodePublisher {

    private final ApplicationEventPublisher publisher;

    public EpisodePublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publish(Episode episode) {
        publisher.publishEvent(EpisodeCreatedEvent.builder()
            .episode(episode)
            .build());
    }
}
