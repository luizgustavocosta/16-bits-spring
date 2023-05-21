package com.costa.luiz.events.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Set;

@Data
public class Podcast {

    @JsonIgnore
    private String id;
    private String country;
    private String name;
    private String owner;
    private Set<Episode> episodes;
}
