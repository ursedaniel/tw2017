package com.proiect.tw.vo;

/**
 * Created by JACK on 6/11/2017.
 */
public class ProjectVO {

    Integer id;
    Integer course_id;
    String title;
    String description;
    String file;

    public ProjectVO() {}

    public ProjectVO(Integer id, Integer course_id, String title, String description, String file) {
        this.id = id;
        this.course_id = course_id;
        this.title = title;
        this.description = description;
        this.file = file;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
