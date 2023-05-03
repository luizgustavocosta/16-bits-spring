package com.costa.luiz.mocks.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerCreatedListener implements ApplicationListener<CustomerCreatedEvent> {

     private final Logger logger = LoggerFactory.getLogger(CustomerCreatedListener.class);

    @Override
    public void onApplicationEvent(CustomerCreatedEvent event) {
        logger.info("Event received with payload {}", event.getPayload());
    }
}
