package com.proiect.tw.service;


import com.proiect.tw.vo.TeacherVO;
import com.proiect.tw.vo.search.TeacherSearchVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by JACK on 4/19/2017.
 */
public interface TeacherService {

    Page<TeacherVO> getTeachers(Pageable pageable);
    Page<TeacherVO> getTeachers(TeacherSearchVO search, Pageable pageable);
    TeacherVO getTeacher(Integer id);

    void createTeacher(TeacherVO teacherVO);
    void updateTeacher(Integer id, TeacherVO teacherVO);
    void deleteTeacher(Integer id);
}
