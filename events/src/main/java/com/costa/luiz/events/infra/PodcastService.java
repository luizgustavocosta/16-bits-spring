package com.costa.luiz.events.infra;

import com.costa.luiz.events.domain.Podcast;
import com.costa.luiz.events.domain.PodcastPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class PodcastService {

    private final PodcastPublisher podcastPublisher;
    private final EpisodeService episodeService;

    private final List<Podcast> podcasts = new ArrayList<>();

    public PodcastService(PodcastPublisher podcastPublisher, EpisodeService episodeService) {
        this.podcastPublisher = podcastPublisher;
        this.episodeService = episodeService;
    }

    @Async
    public void create(Podcast podcast) {
        log.info("New Podcast received");
        podcast.setId(UUID.randomUUID().toString());
        podcastPublisher.publish(podcast);
        if (!podcast.getEpisodes().isEmpty()) {
            podcast.getEpisodes().forEach(episodeService::publish);
        }
        podcasts.add(podcast);
    }

    public List<Podcast> retrieveAll() {
        return podcasts;
    }

    public void deleteById(String id) {
        for (int index = 0; index < podcasts.size(); index++) {
            if (podcasts.get(index).getId().equalsIgnoreCase(id) && !podcasts.isEmpty()) {
                podcasts.remove(index);
                break;
            }
        }
    }

    public Podcast retrieveBy(String id) {
        return podcasts.stream()
            .filter(podcast -> id.equalsIgnoreCase(podcast.getId()))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Id" + id + " cannot be found"));
    }
}
