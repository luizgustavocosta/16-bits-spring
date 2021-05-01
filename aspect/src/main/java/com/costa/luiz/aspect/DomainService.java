package com.costa.luiz.aspect;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DomainService {

    public Object findBy(Long id) {
        try {
            Thread.sleep(new Random().nextInt(500));
        } catch (InterruptedException exception) {
            //do some logging
        }
        return id;
    }
}
