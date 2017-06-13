package com.proiect.tw.model;

import javax.persistence.*;

/**
 * Created by JACK on 4/19/2017.
 */

@Entity
@Table(name = "TEACHERS")
public class Teacher {

    Integer id;
    String name;
    Integer course_id;
    Integer rating;
    String title;
    String email;
    String website;

    public Teacher() {}

    public Teacher(Integer id, String name, Integer course_id, Integer rating, String title, String email, String website) {
        this.id = id;
        this.name = name;
        this.course_id = course_id;
        this.rating = rating;
        this.title = title;
        this.email = email;
        this.website = website;
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

    @Column(name = "NAME")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "COURSE_ID")
    public Integer getCourse_id() {
        return course_id;
    }
    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    @Column(name = "RATING")
    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "WEBSITE")
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
}