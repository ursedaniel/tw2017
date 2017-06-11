package com.proiect.tw.controller;

import com.proiect.tw.service.ProjectService;
import com.proiect.tw.vo.ProjectVO;
import com.proiect.tw.vo.search.ProjectSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * Created by JACK on 6/11/2017.
 */
@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping("/projects")
    public Page<ProjectVO> getProjects(Pageable pageable) {

        return projectService.getProjects(pageable);
    }

    @RequestMapping(value = "/projects/search")
    public Page<ProjectVO> searchProjects(@ModelAttribute ProjectSearchVO searchVO, Pageable page) {

        return projectService.getProjects(searchVO, page);
    }

    @RequestMapping("/projects/{id}")
    public ProjectVO getProject(@PathVariable("id") Integer id) {

        return projectService.getProject(id);
    }

    @RequestMapping(value = "/projects", method = RequestMethod.POST)
    public void createProject(@RequestBody ProjectVO projectVO) {

        projectService.createProject(projectVO);
    }

    @RequestMapping(value = "/projects/{id}", method = RequestMethod.PUT)
    public void updateProject(@PathVariable("id") Integer id, @RequestBody ProjectVO projectVO) {

        projectService.updateProject(id, projectVO);
    }

    @RequestMapping(value = "/projects/{id}", method = RequestMethod.DELETE)
    public void deleteProject(@PathVariable("id") Integer id) {

        projectService.deleteProject(id);
    }
}

