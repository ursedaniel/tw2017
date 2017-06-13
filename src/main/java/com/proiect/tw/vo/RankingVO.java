package com.proiect.tw.vo;

import com.proiect.tw.model.Ranking;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by JACK on 6/13/2017.
 */
public class RankingVO {

    Integer id;
    Integer id_user;
    Integer teacher_id;
    Integer grade;

    public RankingVO() {}

    public RankingVO(Integer id, Integer id_user, Integer teacher_id, Integer grade) {
        this.id = id;
        this.id_user = id_user;
        this.teacher_id = teacher_id;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
