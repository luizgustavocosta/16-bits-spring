package com.costa.luiz.events.controllers;

import com.costa.luiz.events.domain.Podcast;
import com.costa.luiz.events.view.PodcastDTO;
import com.costa.luiz.events.infra.PodcastService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/v1/podcasts")
public class PodcastController {

    private final PodcastService podcastService;

    public PodcastController(PodcastService podcastService) {
        this.podcastService = podcastService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @PostMapping
    public ResponseEntity<PodcastDTO> create(@RequestBody Podcast podcast) {
        podcastService.create(podcast);
        return ResponseEntity.accepted().body(PodcastDTO.builder().build());

    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        podcastService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public PodcastDTO retrieveBy(@PathVariable("id") String id) {
        var podcast = podcastService.retrieveBy(id);
        var podcastDTO = PodcastDTO.builder()
            .id(podcast.getId())
            .name(podcast.getName())
            .country(podcast.getCountry())
            .episodes(podcast.getEpisodes())
            .owner(podcast.getOwner())
            .build();

        return podcastDTO.add(linkTo(PodcastController.class)
            .slash(podcastDTO.getId())
            .withSelfRel());
    }

    @GetMapping
    public CollectionModel<PodcastDTO> retrieveAll() {
        var podcasts = podcastService.retrieveAll().stream()
            .map(podcast -> PodcastDTO.builder()
                .id(podcast.getId())
                .name(podcast.getName())
                .country(podcast.getCountry())
                .episodes(podcast.getEpisodes())
                .owner(podcast.getOwner())
                .build())
            .collect(Collectors.toList())
            .stream()
            .map(podcastDTO -> {
                Link selfLink = linkTo(PodcastController.class).slash(podcastDTO.getId()).withSelfRel();
                podcastDTO.add(selfLink);
                return podcastDTO;
            })
            .collect(Collectors.toUnmodifiableList());

        return CollectionModel.of(podcasts, linkTo(PodcastController.class).withSelfRel());
    }
}
