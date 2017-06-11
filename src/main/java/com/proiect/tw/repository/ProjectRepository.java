package com.proiect.tw.repository;

import com.proiect.tw.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by JACK on 6/11/2017.
 */
public interface ProjectRepository extends JpaRepository<Project, Integer>, JpaSpecificationExecutor<Project> {

    @Query("select p from Project p where p.course_id = ?1")
    Page<Project> getProjectsByQuery(Integer id_course, Pageable pageable);
}
