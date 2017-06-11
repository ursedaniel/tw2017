package com.proiect.tw.vo;

/**
 * Created by JACK on 6/11/2017.
 */
public class BookVO {

    Integer id;
    Integer course_id;
    String title;
    String author;
    String location;

    public BookVO() {}

    public BookVO(Integer id, Integer course_id, String title, String author, String location) {
        this.id = id;
        this.course_id = course_id;
        this.title = title;
        this.author = author;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

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
