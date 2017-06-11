package com.proiect.tw.service.impl;

import com.proiect.tw.exception.BusinessException;
import com.proiect.tw.model.Book;
import com.proiect.tw.model.Course;
import com.proiect.tw.model.Doc;
import com.proiect.tw.model.Project;
import com.proiect.tw.repository.BookRepository;
import com.proiect.tw.repository.CourseRepository;
import com.proiect.tw.repository.DocRepository;
import com.proiect.tw.repository.ProjectRepository;
import com.proiect.tw.repository.specification.CourseSpecification;
import com.proiect.tw.service.CourseService;
import com.proiect.tw.service.DocService;
import com.proiect.tw.vo.BookVO;
import com.proiect.tw.vo.CourseVO;
import com.proiect.tw.vo.DocVO;
import com.proiect.tw.vo.ProjectVO;
import com.proiect.tw.vo.convertor.BookConvertor;
import com.proiect.tw.vo.convertor.CourseConvertor;
import com.proiect.tw.vo.convertor.DocConvertor;
import com.proiect.tw.vo.convertor.ProjectConvertor;
import com.proiect.tw.vo.search.CourseSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by JACK on 4/21/2017.
 */
@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseConvertor courseConvertor;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookConvertor bookConvertor;

    @Autowired
    private DocRepository docRepository;

    @Autowired
    private DocConvertor docConvertor;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectConvertor projectConvertor;

    private Page<CourseVO> convertToVO(Page<Course> page) {
        return page.map(courseConvertor::toVO);
    }

    private Page<BookVO> convertToVOBooks(Page<Book> page) {
        return page.map(bookConvertor::toVO);
    }

    private Page<DocVO> convertToVODocs(Page<Doc> page) {
        return page.map(docConvertor::toVO);
    }

    private Page<ProjectVO> convertToVOProjects(Page<Project> page) {
        return page.map(projectConvertor::toVO);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CourseVO> getCourses(Pageable pageable) {
        return convertToVO(courseRepository.findAll(pageable));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CourseVO> getCourses(CourseSearchVO search, Pageable pageable) {

        return convertToVO(courseRepository.findAll(CourseSpecification.searchByVO(search), pageable));
    }

    @Override
    public CourseVO getCourse(Integer id) {

        Course course = courseRepository.findOne(id);

        if (course == null) {
            throw new BusinessException( "Cursul cu id-ul " + id + " nu exista in baza de date! ");
        }

        return courseConvertor.toVO(course);
    }

    @Override
    public void createCourse(CourseVO courseVO) {

        if (courseRepository.findOne(courseVO.getId()) != null) {
            throw new BusinessException(" Cursul cu id-ul " + courseVO.getId() + " exista deja in baza de date! ");
        }
        else {
            courseRepository.save(courseConvertor.fromVO(courseVO));
        }
    }

    @Override
    public void updateCourse(Integer id, CourseVO courseVO) {

        if (courseRepository.findOne(id) == null) {
            throw new BusinessException(" Cursul cu id-ul " + id + " nu exista in baza de date! ");
        }
        else {
            courseRepository.save(courseConvertor.fromVO(courseVO));
        }
    }

    @Override
    public void deleteCourse(Integer id) {
        courseRepository.delete(id);
    }

    @Override
    public Page<BookVO> getBooksByCourse(Integer id_course, Pageable pageable) {

        return convertToVOBooks(bookRepository.getBooksByQuery(id_course, pageable));
    }

    @Override
    public Page<DocVO> getDocsByCourse(Integer id_course, Pageable pageable) {

        return convertToVODocs(docRepository.getDocsByQuery(id_course, pageable));
    }

    @Override
    public Page<ProjectVO> getProjectsByCourse(Integer id_course, Pageable pageable) {

        return convertToVOProjects(projectRepository.getProjectsByQuery(id_course, pageable));
    }
}
