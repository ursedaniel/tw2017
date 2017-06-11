package com.proiect.tw.controller;

import com.proiect.tw.service.CourseService;
import com.proiect.tw.vo.CourseVO;
import com.proiect.tw.vo.search.CourseSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * Created by JACK on 4/21/2017.
 */
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/courses")
    public Page<CourseVO> getCourses(Pageable pageable) {
        return courseService.getCourses(pageable);
    }

    @RequestMapping(value = "/courses/search")
    public Page<CourseVO> searchCourses(@ModelAttribute CourseSearchVO searchVO, Pageable page) {
        return courseService.getCourses(searchVO, page);
    }

    @RequestMapping("/courses/{id}")
    public CourseVO getCourse(@PathVariable("id") Integer id) {
        return courseService.getCourse(id);
    }

    @RequestMapping(value = "/courses", method = RequestMethod.POST)
    public void createCourse(@RequestBody CourseVO courseVO) {
        courseService.createCourse(courseVO);
    }

    @RequestMapping(value = "/courses/{id}", method = RequestMethod.PUT)
    public void updateCourse(@PathVariable("id") Integer id, @RequestBody CourseVO courseVO) {
        courseService.updateCourse(id, courseVO);
    }

    @RequestMapping(value = "/courses/{id}", method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable("id") Integer id) {
        courseService.deleteCourse(id);
    }
}