package com.proiect.tw.vo.search;

/**
 * Created by JACK on 4/21/2017.
 */
public class CourseSearchVO extends DefaultSearchVO{

    private String name;
    private Integer year;

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
}
