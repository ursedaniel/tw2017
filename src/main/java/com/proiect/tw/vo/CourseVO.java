package com.proiect.tw.vo;

/**
 * Created by JACK on 4/21/2017.
 */
public class CourseVO {

    Integer id;
    String name;
    Integer year;
    String main_teacher;
    String type;

    public CourseVO() {}

    public CourseVO(Integer id, String name, Integer year, String main_teacher, String type) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.main_teacher = main_teacher;
        this.type = type;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getMain_teacher() {
        return main_teacher;
    }

    public void setMain_teacher(String main_teacher) {
        this.main_teacher = main_teacher;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
