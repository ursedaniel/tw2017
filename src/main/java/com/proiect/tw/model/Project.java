package com.proiect.tw.model;

import javax.persistence.*;

/**
 * Created by JACK on 6/11/2017.
 */
@Entity
@Table(name = "PROJECTS")
public class Project {

    Integer id;
    Integer course_id;
    String title;
    String description;
    String file;

    public Project() {}

    public Project(Integer id, Integer course_id, String title, String description, String file) {
        this.id = id;
        this.course_id = course_id;
        this.title = title;
        this.description = description;
        this.file = file;
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

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "FILE")
    public String getFile() {
        return file;
    }
    public void setFile(String file) {
        this.file = file;
    }
}
