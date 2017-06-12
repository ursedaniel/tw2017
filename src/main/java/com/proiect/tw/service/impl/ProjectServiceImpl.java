package com.proiect.tw.service.impl;

import com.proiect.tw.exception.BusinessException;
import com.proiect.tw.model.Project;
import com.proiect.tw.repository.ProjectRepository;
import com.proiect.tw.repository.specification.ProjectSpecification;
import com.proiect.tw.service.ProjectService;
import com.proiect.tw.vo.ProjectVO;
import com.proiect.tw.vo.convertor.ProjectConvertor;
import com.proiect.tw.vo.search.ProjectSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by JACK on 6/11/2017.
 */
@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectConvertor projectConvertor;

    private Page<ProjectVO> convertToVO(Page<Project> page) {

        return page.map(projectConvertor::toVO);
    }

    @Override
    public Page<ProjectVO> getProjects(Pageable pageable) {

        return convertToVO(projectRepository.findAll(pageable));
    }

    @Override
    public Page<ProjectVO> getProjects(ProjectSearchVO searchVO, Pageable pageable) {

        return convertToVO(projectRepository.findAll(ProjectSpecification.searchByVO(searchVO), pageable));
    }

    @Override
    public ProjectVO getProject(Integer id) {

        Project project = projectRepository.findOne(id);

        if (project == null) {
            throw new BusinessException( "Proiectul cu id-ul " + id + " nu exista in baza de date! ");
        }

        return projectConvertor.toVO(project);
    }

    @Override
    public void createProject(ProjectVO projectVO) {

        projectRepository.save(projectConvertor.fromVO(projectVO));
    }

    @Override
    public void updateProject(Integer id, ProjectVO projectVO) {

        if (projectRepository.findOne(id) == null) {
            throw new BusinessException(" Proiectul cu id-ul " + id + " nu exista in baza de date! ");
        }
        else {
            projectRepository.save(projectConvertor.fromVO(projectVO));
        }
    }

    @Override
    public void deleteProject(Integer id) {

        projectRepository.delete(id);
    }
}
