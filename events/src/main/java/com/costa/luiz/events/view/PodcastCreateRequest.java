package com.costa.luiz.events.view;

import com.costa.luiz.events.domain.Episode;
import lombok.Data;

import java.util.Set;

@Data
public class PodcastCreateRequest {

    private String country;
    private String name;
    private String owner;
    private Set<Episode> episodes;
}
