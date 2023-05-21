package com.costa.luiz.events.domain;

import lombok.Data;

@Data
public class Episode {

    private String id;
    private String title;
    private String description;
    private long lengthInSeconds;
}
