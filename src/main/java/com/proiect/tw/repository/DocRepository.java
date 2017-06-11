package com.proiect.tw.repository;

import com.proiect.tw.model.Doc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by JACK on 6/11/2017.
 */
public interface DocRepository extends JpaRepository<Doc, Integer>, JpaSpecificationExecutor<Doc> {

    @Query("select d from Doc d where d.course_id = ?1")
    Page<Doc> getDocsByQuery(Integer id_course, Pageable pageable);
}
