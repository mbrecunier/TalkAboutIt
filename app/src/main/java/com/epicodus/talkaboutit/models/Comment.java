package com.epicodus.talkaboutit.models;

/**
 * Created by Guest on 5/2/16.
 */
public class Comment {
    private String author;
    private String body;

    public Comment(String author, String body) {
        this.author = author;
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public String getAuthor() {
        return author;
    }
}
