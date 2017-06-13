package com.proiect.tw.model;

import javax.persistence.*;

/**
 * Created by JACK on 6/13/2017.
 */
@Entity
@Table(name = "RANKING")
public class Ranking {

    Integer id;
    Integer id_user;
    Integer teacher_id;
    Integer grade;

    public Ranking() {}

    public Ranking(Integer id, Integer id_user, Integer teacher_id, Integer grade) {
        this.id = id;
        this.id_user = id_user;
        this.teacher_id = teacher_id;
        this.grade = grade;
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

    @Column(name = "ID_USER")
    public Integer getId_user() {
        return id_user;
    }
    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    @Column(name = "TEACHER_ID")
    public Integer getTeacher_id() {
        return teacher_id;
    }
    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    @Column(name = "GRADE")
    public Integer getGrade() {
        return grade;
    }
    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
