package com.proiect.tw.service;

import com.proiect.tw.vo.ProjectVO;
import com.proiect.tw.vo.search.ProjectSearchVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by JACK on 6/11/2017.
 */
public interface ProjectService {

    Page<ProjectVO> getProjects(Pageable pageable);
    Page<ProjectVO> getProjects(ProjectSearchVO searchVO, Pageable page);
    ProjectVO getProject(Integer id);

    void createProject(ProjectVO projectVO);
    void updateProject(Integer id, ProjectVO projectVO);
    void deleteProject(Integer id);
}
