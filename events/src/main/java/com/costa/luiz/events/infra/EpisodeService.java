package com.costa.luiz.events.infra;

import com.costa.luiz.events.domain.Episode;
import com.costa.luiz.events.domain.EpisodePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class EpisodeService {

    private final EpisodePublisher episodePublisher;

    public EpisodeService(EpisodePublisher episodePublisher) {
        this.episodePublisher = episodePublisher;
    }

    public void create(Episode episode) {
        log.info("New Episode received");
        episode.setId(UUID.randomUUID().toString());
        episodePublisher.publish(episode);
    }
}
