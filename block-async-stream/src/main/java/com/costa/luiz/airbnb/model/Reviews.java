package com.costa.luiz.airbnb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "listingsAndReviews")
public class Reviews {

    @Id
    private String id;
    private String listing_Url;
    private String name;
    private String summary;

    public Reviews() {
    }

    public Reviews(String id, String listing_Url, String name, String summary) {
        this.id = id;
        this.listing_Url = listing_Url;
        this.name = name;
        this.summary = summary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getListing_Url() {
        return listing_Url;
    }

    public void setListing_Url(String listing_Url) {
        this.listing_Url = listing_Url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
