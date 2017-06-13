package com.proiect.tw.controller;


import com.proiect.tw.service.RankingService;
import com.proiect.tw.service.TeacherService;
import com.proiect.tw.vo.GossipVO;
import com.proiect.tw.vo.RankingVO;
import com.proiect.tw.vo.TeacherVO;
import com.proiect.tw.vo.search.TeacherSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * Created by JACK on 4/20/2017.
 */
@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private RankingService rankingService;

    //GET ALL TEACHERS
    @RequestMapping("/teachers")
    public Page<TeacherVO> getTeachers(Pageable pageable) {

        return teacherService.getTeachers(pageable);
    }

    //GET ALL TEACHERS BY NAME OR RATING
    @RequestMapping(value = "/teachers/search")
    public Page<TeacherVO> searchTeachers(@ModelAttribute TeacherSearchVO searchVO, Pageable page) {

        return teacherService.getTeachers(searchVO, page);
    }

    //GET TEACHER BY ID
    @RequestMapping("/teachers/{id}")
    public TeacherVO getTeacher(@PathVariable("id") Integer id) {

        return teacherService.getTeacher(id);
    }

    //CREATE A NEW TEACHER
    @RequestMapping(value = "/teachers", method = RequestMethod.POST)
    public void createTeacher(@RequestBody TeacherVO teacherVO) {

        teacherService.createTeacher(teacherVO);
    }

    //UPDATE AN EXISTING TEACHER
    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.PUT)
    public void updateTeacher(@PathVariable("id") Integer id, @RequestBody TeacherVO teacherVO) {

        teacherService.updateTeacher(id, teacherVO);
    }

    //DELETE A TEACHER
    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.DELETE)
    public void deleteTeacher(@PathVariable("id") Integer id) {

        teacherService.deleteTeacher(id);
    }

    //GET ALL THE GOSSIPS FROM A TEACHER
    @RequestMapping(value = "/teachers/{id_teacher}/gossips")
    public Page<GossipVO> getGossipsByTeacher(@PathVariable("id_teacher") Integer id_teacher, Pageable pageable) {

        return teacherService.getGossipsByTeacher(id_teacher,pageable);
    }

    @RequestMapping(value = "/teachers/{id_teacher}/ranking", method = RequestMethod.POST)
    public void createRanking(@RequestBody RankingVO rankingVO) {

        rankingService.createRanking(rankingVO);
    }
}
