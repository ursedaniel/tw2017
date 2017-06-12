package com.proiect.tw.repository;

import com.proiect.tw.model.Gossip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by JACK on 6/12/2017.
 */
public interface GossipRepository  extends JpaRepository<Gossip, Integer>, JpaSpecificationExecutor<Gossip> {
}
