package com.proiect.tw.vo;

import com.proiect.tw.model.Schedule;

/**
 * Created by JACK on 6/12/2017.
 */
public class ScheduleVO {

    Integer id;
    Integer teacher_id;
    Integer course_id;
    String day;
    String class_group;
    String class_room;
    String starting_at;
    String ending_at;
    String type;

    public ScheduleVO() {}

    public ScheduleVO(Integer id, Integer teacher_id, Integer course_id, String day, String class_group, String class_room, String starting_at, String ending_at, String type) {
        this.id = id;
        this.teacher_id = teacher_id;
        this.course_id = course_id;
        this.day = day;
        this.class_group = class_group;
        this.class_room = class_room;
        this.starting_at = starting_at;
        this.ending_at = ending_at;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getGroup() {
        return class_group;
    }

    public void setGroup(String class_group) {
        this.class_group = class_group;
    }

    public String getClass_room() {
        return class_room;
    }

    public void setClass_room(String class_room) {
        this.class_room = class_room;
    }

    public String getStarting_at() {
        return starting_at;
    }

    public void setStarting_at(String starting_at) {
        this.starting_at = starting_at;
    }

    public String getEnding_at() {
        return ending_at;
    }

    public void setEnding_at(String ending_at) {
        this.ending_at = ending_at;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
