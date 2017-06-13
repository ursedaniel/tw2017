package com.proiect.tw.controller;

import com.proiect.tw.service.GossipService;
import com.proiect.tw.vo.BookVO;
import com.proiect.tw.vo.GossipVO;
import com.proiect.tw.vo.search.BookSearchVO;
import com.proiect.tw.vo.search.GossipSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * Created by JACK on 6/12/2017.
 */
@RestController
public class GossipController {

    @Autowired
    private GossipService gossipService;

    //GET ALL DOCS
    @RequestMapping("/gossips")
    public Page<GossipVO> getGossips(Pageable pageable) {

        return gossipService.getGossips(pageable);
    }

    //GET ALL GOSSIPS BY TITLE
    @RequestMapping(value = "/gossips/search")
    public Page<GossipVO> searchGossips(@ModelAttribute GossipSearchVO searchVO, Pageable page) {

        return gossipService.getGossips(searchVO, page);
    }

    //GET GOSSIP BY ID
    @RequestMapping("/gossips/{id}")
    public GossipVO getGossip(@PathVariable("id") Integer id) {

        return gossipService.getGossip(id);
    }

    //CREATE A NEW GOSSIP
    @RequestMapping(value = "/gossips", method = RequestMethod.POST)
    public void createGossip(@RequestBody GossipVO gossipVO) {

        gossipService.createGossip(gossipVO);
    }

    //UPDATE AN EXISTING GOSSIP
    @RequestMapping(value = "/gossips/{id}", method = RequestMethod.PUT)
    public void updateGossip(@PathVariable("id") Integer id, @RequestBody GossipVO gossipVO) {

        gossipService.updateGossip(id, gossipVO);
    }

    //DELETE A GOSSIP
    @RequestMapping(value = "/gossips/{id}", method = RequestMethod.DELETE)
    public void deleteGossip(@PathVariable("id") Integer id) {

        gossipService.deleteGossip(id);
    }
}
