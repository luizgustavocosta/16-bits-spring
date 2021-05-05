package com.costa.luiz.stream_and_list;

import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    Iterable<Client> findAll() {
        return repository.findAll();
    }

    Stream<Client> readAll() {
        return repository.findAllByStream();
    }
}
