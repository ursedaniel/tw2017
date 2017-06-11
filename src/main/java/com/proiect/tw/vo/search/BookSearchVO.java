package com.proiect.tw.vo.search;

/**
 * Created by JACK on 6/11/2017.
 */
public class BookSearchVO extends DefaultSearchVO{

    String title;
    String author;
    String location;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}
