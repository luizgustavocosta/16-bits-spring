package com.costa.luiz.events.infra;

import com.costa.luiz.events.domain.Episode;
import com.costa.luiz.events.domain.EpisodeCreatedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EpisodeService {
    private final ApplicationEventPublisher publisher;

    public EpisodeService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publish(Episode episode) {
        episode.setId(UUID.randomUUID().toString());
        publisher.publishEvent(EpisodeCreatedEvent.builder()
            .episode(episode)
            .build());
    }
}
