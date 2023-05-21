package com.costa.luiz.events.infra.listener;

import com.costa.luiz.events.domain.PodcastCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PodcastAsyncListener {

    @Async
    @EventListener
    public void handle(PodcastCreatedEvent event) {
        log.info("PodcastCreatedEvent received {}",event);
    }
}
