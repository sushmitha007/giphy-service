package com.stackroute.giphyservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;


@Entity
@Table(name = "gif")
public class Gif {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long gifId;
    @JsonProperty("id")
    private String giphyId;
    private String type;
    @JsonProperty("embed_url")
    private String gifUrl;
    @JsonProperty("url")
    private String gifDetails;
    private String title;
    private String caption;
    @JsonProperty("username")
    private String userName;
    private String rating;
    @JsonProperty("import_datetime")
    private String createdOn;

    public Gif() {
    }

    public Gif(Long gifId, String giphyId, String type, String gifUrl, String gifDetails, String title, String caption, String userName, String rating, String createdOn) {
        this.gifId = gifId;
        this.giphyId = giphyId;
        this.type = type;
        this.gifUrl = gifUrl;
        this.gifDetails = gifDetails;
        this.title = title;
        this.caption = caption;
        this.userName = userName;
        this.rating = rating;
        this.createdOn = createdOn;
    }

    public void setGifId(Long gifId) {
        this.gifId = gifId;
    }

    public Long getGifId() {
        return gifId;
    }

    public String getGiphyId() {
        return giphyId;
    }

    public void setGiphyId(String giphyId) {
        this.giphyId = giphyId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGifUrl() {
        return gifUrl;
    }

    public void setGifUrl(String gifUrl) {
        this.gifUrl = gifUrl;
    }

    public String getGifDetails() {
        return gifDetails;
    }

    public void setGifDetails(String gifDetails) {
        this.gifDetails = gifDetails;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }
}
