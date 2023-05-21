package com.costa.luiz.events.infra.listener;

import com.costa.luiz.events.domain.EpisodeCreatedEvent;
import com.costa.luiz.events.domain.PodcastCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EpisodeAsyncListener {

    @Async
    @EventListener
    public void handle(EpisodeCreatedEvent event) {
        log.info("EpisodeCreatedEvent received {}",event);
        log.info("Time to notify the users - This is a TODO feature");
    }
}
