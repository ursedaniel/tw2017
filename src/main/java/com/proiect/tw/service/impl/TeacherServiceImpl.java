package com.proiect.tw.service.impl;

import com.proiect.tw.exception.BusinessException;
import com.proiect.tw.model.Teacher;
import com.proiect.tw.repository.TeacherRepository;
import com.proiect.tw.repository.specification.TeacherSpecification;
import com.proiect.tw.service.TeacherService;
import com.proiect.tw.vo.TeacherVO;
import com.proiect.tw.vo.convertor.TeacherConvertor;
import com.proiect.tw.vo.search.TeacherSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherConvertor teacherConvertor;

    private Page<TeacherVO> convertToVO(Page<Teacher> page) {
        return page.map(teacherConvertor::toVO);
    }

    @Override
    public Page<TeacherVO> getTeachers(Pageable pageable) {
        return convertToVO(teacherRepository.findAll(pageable));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<TeacherVO> getTeachers(TeacherSearchVO search, Pageable pageable) {
        return convertToVO(teacherRepository.findAll(TeacherSpecification.searchByVO(search), pageable));
    }

    @Override
    public TeacherVO getTeacher(Integer id) {
        Teacher teacher = teacherRepository.findOne(id);

        if (teacher == null) {
            throw new BusinessException(" Profesorul cu id-ul " + id + " nu exista in baza de date");
        }

        return teacherConvertor.toVO(teacher);
    }

    @Override
    public void createTeacher(TeacherVO teacherVO) {
        if (teacherRepository.findOne(teacherVO.getId()) != null) {
            throw new BusinessException(" Profesorul cu id-ul " + teacherVO.getId() + " exista deja in baza de date! ");
        }
        else {
            teacherRepository.save(teacherConvertor.fromVO(teacherVO));
        }
    }

    @Override
    public void updateTeacher(Integer id, TeacherVO teacherVO) {
        if (teacherRepository.findOne(id) == null) {
            throw new BusinessException(" Profesorul cu id-ul " + id + " nu exista in baza de date! ");
        }
        else {
            teacherRepository.save(teacherConvertor.fromVO(teacherVO));
        }
    }

    @Override
    public void deleteTeacher(Integer id) {
        teacherRepository.delete(id);
    }
}
