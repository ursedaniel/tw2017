package com.proiect.tw.vo;

import com.proiect.tw.model.Gossip;

import java.util.Date;

/**
 * Created by JACK on 6/12/2017.
 */
public class GossipVO {

    Integer id;
    Integer course_id;
    Integer teacher_id;
    String title;
    String posting_date;
    String content;

    public GossipVO() {}

    public GossipVO(Integer id, Integer course_id, Integer teacher_id, String title, String posting_date, String content) {
        this.id = id;
        this.course_id = course_id;
        this.teacher_id = teacher_id;
        this.title = title;
        this.posting_date = posting_date;
        this.content = content;
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

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosting_date() {
        return posting_date;
    }

    public void setPosting_date(String posting_date) {
        this.posting_date = posting_date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
