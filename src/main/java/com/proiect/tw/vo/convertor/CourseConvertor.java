package com.proiect.tw.vo.convertor;

import com.proiect.tw.model.Course;
import com.proiect.tw.vo.CourseVO;
import org.springframework.stereotype.Service;

/**
 * Created by JACK on 4/21/2017.
 */
@Service
public class CourseConvertor {

    public CourseVO toVO(Course course){
        CourseVO courseVO = new CourseVO();

        courseVO.setId(course.getId());
        courseVO.setName(course.getName());
        courseVO.setYear(course.getYear());
        courseVO.setType(course.getType());
        courseVO.setMain_teacher(course.getMain_teacher());

        return courseVO;
    }

    public Course fromVO(CourseVO courseVO){
        Course course = new Course();

        course.setId(courseVO.getId());
        course.setName(courseVO.getName());
        course.setYear(courseVO.getYear());
        course.setType(courseVO.getType());
        course.setMain_teacher(courseVO.getMain_teacher());

        return course;
    }
}
