package com.costa.luiz.events.infra.listener;

import com.costa.luiz.events.domain.PodcastCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PodcastCreatedListener implements ApplicationListener<PodcastCreatedEvent> {

    @Override
    public void onApplicationEvent(PodcastCreatedEvent event) {
        log.info("Event received on listener -> {}", event);
    }
}
