package com.proiect.tw.repository;

import com.proiect.tw.model.Gossip;
import com.proiect.tw.vo.GossipVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by JACK on 6/12/2017.
 */
public interface GossipRepository  extends JpaRepository<Gossip, Integer>, JpaSpecificationExecutor<Gossip> {

    @Query("select g from Gossip g where g.course_id = ?1")
    Page<Gossip> getGossipsByQuery(Integer id_course, Pageable pageable);
}
