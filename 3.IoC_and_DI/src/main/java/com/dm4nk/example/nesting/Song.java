package com.dm4nk.example.nesting;

import lombok.ToString;

@ToString
public class Song {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
