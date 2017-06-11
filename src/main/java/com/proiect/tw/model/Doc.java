package com.proiect.tw.model;

import javax.persistence.*;

/**
 * Created by JACK on 6/11/2017.
 */
@Entity
@Table(name = "DOCS")
public class Doc {

    Integer id;
    Integer course_id;
    String title;
    String link;

    public Doc() {}

    public Doc(Integer id, Integer course_id, String title, String link) {
        this.id = id;
        this.course_id = course_id;
        this.title = title;
        this.link = link;
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

    @Column(name = "LINK")
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
}
