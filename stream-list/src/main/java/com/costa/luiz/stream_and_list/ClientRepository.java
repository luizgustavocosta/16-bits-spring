package com.costa.luiz.stream_and_list;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

    @Query("SELECT c from Client c")
    Stream<Client> findAllByStream();
}
