package com.proiect.tw.model;

import javax.persistence.*;

/**
 * Created by JACK on 4/21/2017.
 */
@Entity
@Table(name = "COURSES")
public class Course {

    Integer id;
    String name;
    Integer year;
    String main_teacher;
    String type;

    public Course() {}

    public Course(Integer id, String name, Integer year, String main_teacher, String type) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.main_teacher = main_teacher;
        this.type = type;
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

    @Column(name = "YEAR")
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }

    @Column(name = "MAIN_TEACHER")
    public String getMain_teacher() {
        return main_teacher;
    }
    public void setMain_teacher(String main_teacher) {
        this.main_teacher = main_teacher;
    }

    @Column(name = "TYPE")
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
