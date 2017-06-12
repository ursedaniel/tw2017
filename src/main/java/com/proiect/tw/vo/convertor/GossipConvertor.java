package com.proiect.tw.vo.convertor;

import com.proiect.tw.model.Gossip;
import com.proiect.tw.util.DateUtils;
import com.proiect.tw.vo.GossipVO;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

/**
 * Created by JACK on 6/12/2017.
 */
@Service
public class GossipConvertor {

    public GossipVO toVO(Gossip gossip) {
        GossipVO gossipVO = new GossipVO();

        gossipVO.setId(gossip.getId());
        gossipVO.setCourse_id(gossip.getCourse_id());
        gossipVO.setTeacher_id(gossip.getTeacher_id());
        gossipVO.setTitle(gossip.getTitle());
        if (gossip.getPosting_date() != null){
            gossipVO.setPosting_date(new SimpleDateFormat(DateUtils.dateTimeFormat).format(gossip.getPosting_date()));
        }
        gossipVO.setContent(gossip.getContent());

        return gossipVO;
    }

    public Gossip fromVO(GossipVO gossipVO) {
        Gossip gossip = new Gossip();

        gossip.setId(gossipVO.getId());
        gossip.setCourse_id(gossipVO.getCourse_id());
        gossip.setTeacher_id(gossipVO.getTeacher_id());
        gossip.setTitle(gossipVO.getTitle());
        gossip.setContent(gossipVO.getContent());

        return gossip;
    }
}
