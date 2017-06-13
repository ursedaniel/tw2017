package com.proiect.tw.vo.search;

/**
 * Created by JACK on 6/13/2017.
 */
public class ScheduleSearchVO extends DefaultSearchVO{

    String day;
    String class_room;
    String group;

    public String getDay() {
        return day;
    }
    public void setDay(String day) {
        this.day = day;
    }

    public String getClass_room() {
        return class_room;
    }
    public void setClass_room(String class_room) {
        this.class_room = class_room;
    }

    public String getGroup() {
        return group;
    }
    public void setGroup(String group) {
        this.group = group;
    }
}
