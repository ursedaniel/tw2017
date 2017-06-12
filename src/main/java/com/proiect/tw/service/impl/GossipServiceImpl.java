package com.proiect.tw.service.impl;

import com.proiect.tw.exception.BusinessException;
import com.proiect.tw.model.Gossip;
import com.proiect.tw.repository.GossipRepository;
import com.proiect.tw.repository.specification.GossipSpecification;
import com.proiect.tw.service.GossipService;
import com.proiect.tw.vo.GossipVO;
import com.proiect.tw.vo.convertor.GossipConvertor;
import com.proiect.tw.vo.search.GossipSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by JACK on 6/12/2017.
 */
@Service
public class GossipServiceImpl implements GossipService {

    @Autowired
    private GossipRepository gossipRepository;

    @Autowired
    private GossipConvertor gossipConvertor;

    private Page<GossipVO> convertToVO(Page<Gossip> page) {

        return page.map(gossipConvertor::toVO);
    }

    @Override
    public Page<GossipVO> getGossips(Pageable pageable) {

        return convertToVO(gossipRepository.findAll(pageable));
    }

    @Override
    public Page<GossipVO> getGossips(GossipSearchVO searchVO, Pageable pageable) {

        return convertToVO(gossipRepository.findAll(GossipSpecification.searchByVO(searchVO), pageable));
    }

    @Override
    public GossipVO getGossip(Integer id) {

        Gossip gossip = gossipRepository.findOne(id);

        if (gossip == null) {
            throw new BusinessException( "Barfa cu id-ul " + id + " nu exista in baza de date! ");
        }

        return gossipConvertor.toVO(gossip);
    }

    @Override
    public void createGossip(GossipVO gossipVO) {

        gossipRepository.save(gossipConvertor.fromVO(gossipVO));
    }

    @Override
    public void updateGossip(Integer id, GossipVO gossipVO) {

        if (gossipRepository.findOne(id) == null) {
            throw new BusinessException(" Barfa cu id-ul " + id + " nu exista in baza de date! ");
        }
        else {
            gossipRepository.save(gossipConvertor.fromVO(gossipVO));
        }
    }

    @Override
    public void deleteGossip(Integer id) {

        gossipRepository.delete(id);
    }
}
