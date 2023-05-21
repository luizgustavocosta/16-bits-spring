package com.costa.luiz.events.view;

import com.costa.luiz.events.domain.Episode;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class PodcastDTO extends RepresentationModel<PodcastDTO> {

    private String id;
    private String country;
    private String name;
    private String owner;
    private Set<Episode> episodes;
}
