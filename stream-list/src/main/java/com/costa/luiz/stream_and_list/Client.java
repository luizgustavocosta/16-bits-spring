package com.costa.luiz.stream_and_list;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Cacheable(false)
public class Client {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Client() {
    }

    public Client(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static final class ClientBuilder {
        private String name;

        private ClientBuilder() {
        }

        public static ClientBuilder aClient() {
            return new ClientBuilder();
        }

        public ClientBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public Client build() {
            Client client = new Client();
            client.setName(name);
            return client;
        }
    }
}
