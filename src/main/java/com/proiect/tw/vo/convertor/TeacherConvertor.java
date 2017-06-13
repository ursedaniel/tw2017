package com.proiect.tw.vo.convertor;

import com.proiect.tw.model.Teacher;
import com.proiect.tw.vo.TeacherVO;
import org.springframework.stereotype.Service;

/**
 * Created by JACK on 4/19/2017.
 */
@Service
public class TeacherConvertor {

    public TeacherVO toVO(Teacher teacher){
        TeacherVO teacherVO = new TeacherVO();

        teacherVO.setId(teacher.getId());
        teacherVO.setName(teacher.getName());
        teacherVO.setCourse_id(teacher.getCourse_id());
        teacherVO.setEmail(teacher.getEmail());
        teacherVO.setRating(teacher.getRating());
        teacherVO.setWebsite(teacher.getWebsite());
        teacherVO.setTitle(teacher.getTitle());

        return teacherVO;
    }

    public Teacher fromVO(TeacherVO teacherVO){
        Teacher teacher = new Teacher();

        teacher.setId(teacherVO.getId());
        teacher.setName(teacherVO.getName());
        teacher.setCourse_id(teacherVO.getCourse_id());
        teacher.setEmail(teacherVO.getEmail());
        teacher.setRating(teacherVO.getRating());
        teacher.setWebsite(teacherVO.getWebsite());
        teacher.setTitle(teacherVO.getTitle());

        return teacher;
    }
}
