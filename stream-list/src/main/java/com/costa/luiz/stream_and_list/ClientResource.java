package com.costa.luiz.stream_and_list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/client")
public class ClientResource {

    @Autowired
    private final ClientService service;

    public ClientResource(ClientService service) {
        this.service = service;
    }

    @GetMapping("/list")
    ResponseEntity<Iterable<Client>> findAll() {
        return new ResponseEntity(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/stream")
    Stream<Client> findAllInStreamMode() {
        return service.readAll();
    }
}
