package com.proiect.tw.vo;

import com.proiect.tw.model.Course;

/**
 * Created by JACK on 4/19/2017.
 */

public class TeacherVO {

    Integer id;
    String name;
    Integer course_id;
    Integer rating;
    String title;
    String email;
    String website;

    public TeacherVO() {}

    public TeacherVO(Integer id, String name, Integer course_id, Integer rating, String title, String email, String website) {
        this.id = id;
        this.name = name;
        this.course_id = course_id;
        this.rating = rating;
        this.title = title;
        this.email = email;
        this.website = website;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
