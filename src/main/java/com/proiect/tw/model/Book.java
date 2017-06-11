package com.proiect.tw.model;

import javax.persistence.*;

/**
 * Created by JACK on 6/11/2017.
 */
@Entity
@Table(name = "BOOKS")
public class Book {

    Integer id;
    Integer course_id;
    String title;
    String author;
    String location;

    public Book(){}

    public Book(Integer id, Integer course_id, String title, String author, String location) {
        this.id = id;
        this.course_id = course_id;
        this.title = title;
        this.author = author;
        this.location = location;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "COURSE_ID")
    public Integer getCourse_id() {
        return course_id;
    }
    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "AUTHOR")
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(name = "LOCATION")
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}
