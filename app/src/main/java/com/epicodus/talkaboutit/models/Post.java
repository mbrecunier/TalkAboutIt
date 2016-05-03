package com.epicodus.talkaboutit.models;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guest on 5/2/16.
 */
@Parcel
public class Post {
    private String title;
    private String body;
    private String author;
    private String category;

    public Post(String title, String body, String author, String category) {
        this.title = title;
        this.body = body;
        this.author = author;
        this.category = category;
    }

    public Post() {}

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }
}
