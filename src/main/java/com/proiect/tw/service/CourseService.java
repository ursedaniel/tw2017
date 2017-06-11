package com.proiect.tw.service;

import com.proiect.tw.vo.BookVO;
import com.proiect.tw.vo.CourseVO;
import com.proiect.tw.vo.search.CourseSearchVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by JACK on 4/21/2017.
 */
public interface CourseService {
    Page<CourseVO> getCourses(Pageable pageable);

    Page<CourseVO> getCourses(CourseSearchVO searchVO, Pageable page);

    CourseVO getCourse(Integer id);

    void createCourse(CourseVO courseVO);

    void updateCourse(Integer id, CourseVO courseVO);

    void deleteCourse(Integer id);


    Page<BookVO> getBooksByCourse(Integer id_course, Pageable pageable);
}
