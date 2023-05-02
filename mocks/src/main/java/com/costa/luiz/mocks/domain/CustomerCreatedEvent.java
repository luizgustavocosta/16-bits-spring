package com.costa.luiz.mocks.domain;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class CustomerCreatedEvent extends ApplicationEvent {

    private final String payload;

    public CustomerCreatedEvent(Object source, Clock clock, String payload) {
        super(source, clock);
        this.payload = payload;
    }

    public String getPayload() {
        return payload;
    }
}
