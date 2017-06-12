package com.proiect.tw.vo.search;

/**
 * Created by JACK on 4/19/2017.
 */
public class TeacherSearchVO extends DefaultSearchVO{

    private String name;
    private Integer rating;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
