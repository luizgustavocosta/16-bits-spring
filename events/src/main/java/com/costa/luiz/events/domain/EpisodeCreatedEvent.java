package com.costa.luiz.events.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

@Getter
@Builder
@Slf4j
public class EpisodeCreatedEvent  extends ApplicationEvent {

    private final transient Episode episode;

    public EpisodeCreatedEvent(Object source) {
        super(source);
        this.episode = (Episode) source;
        log.info("Episode {} received", episode.getTitle());
    }
}
