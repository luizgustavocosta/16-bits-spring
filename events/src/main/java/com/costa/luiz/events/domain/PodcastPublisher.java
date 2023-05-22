package com.costa.luiz.events.domain;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class PodcastPublisher {

    private final ApplicationEventPublisher publisher;

    public PodcastPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publish(Podcast podcast) {
        publisher.publishEvent(PodcastCreatedEvent.builder()
            .podcast(podcast)
            .build());
    }
}
