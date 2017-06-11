package com.proiect.tw.vo.convertor;

import com.proiect.tw.model.Project;
import com.proiect.tw.vo.ProjectVO;
import org.springframework.stereotype.Service;

/**
 * Created by JACK on 6/11/2017.
 */
@Service
public class ProjectConvertor {

    public ProjectVO toVO(Project project){
        ProjectVO projectVO = new ProjectVO();

        projectVO.setId(project.getId());
        projectVO.setCourse_id(project.getCourse_id());
        projectVO.setTitle(project.getTitle());
        projectVO.setDescription(project.getDescription());
        projectVO.setFile(project.getFile());

        return projectVO;
    }

    public Project fromVO(ProjectVO projectVO){
        Project project = new Project();

        project.setId(projectVO.getId());
        project.setCourse_id(projectVO.getCourse_id());
        project.setTitle(projectVO.getTitle());
        project.setDescription(projectVO.getDescription());
        project.setFile(projectVO.getFile());

        return project;
    }
}
