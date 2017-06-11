package com.proiect.tw.vo;

/**
 * Created by JACK on 6/11/2017.
 */
public class DocVO {

    Integer id;
    Integer course_id;
    String title;
    String link;

    public DocVO() {}

    public DocVO(Integer id, Integer course_id, String title, String link) {
        this.id = id;
        this.course_id = course_id;
        this.title = title;
        this.link = link;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
