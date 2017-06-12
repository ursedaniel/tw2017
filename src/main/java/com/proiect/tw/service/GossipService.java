package com.proiect.tw.service;

import com.proiect.tw.vo.BookVO;
import com.proiect.tw.vo.GossipVO;
import com.proiect.tw.vo.search.GossipSearchVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by JACK on 6/12/2017.
 */
public interface GossipService {

    Page<GossipVO> getGossips(Pageable pageable);
    Page<GossipVO> getGossips(GossipSearchVO searchVO, Pageable page);
    GossipVO getGossip(Integer id);

    void createGossip(GossipVO gossipVO);
    void updateGossip(Integer id, GossipVO gossipVO);
    void deleteGossip(Integer id);
}
