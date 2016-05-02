package com.epicodus.talkaboutit.models;

import org.parceler.Parcel;

/**
 * Created by Guest on 5/2/16.
 */
@Parcel
public class Comment {
    private String author;
    private String body;

    public Comment(String author, String body) {
        this.author = author;
        this.body = body;
    }

    public Comment() {}

    public String getBody() {
        return body;
    }

    public String getAuthor() {
        return author;
    }
}
