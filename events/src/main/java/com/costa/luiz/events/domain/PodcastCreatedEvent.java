package com.costa.luiz.events.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
@Builder
public class PodcastCreatedEvent extends ApplicationEvent {
    private final transient Podcast podcast;

    public PodcastCreatedEvent(Object source) {
        super(source);
        this.podcast = (Podcast) source;
    }
}
