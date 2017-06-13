package com.proiect.tw.vo.convertor;

import com.proiect.tw.model.Ranking;
import com.proiect.tw.vo.RankingVO;
import org.springframework.stereotype.Service;

/**
 * Created by JACK on 6/13/2017.
 */
@Service
public class RankingConvertor {

    public RankingVO toVO(Ranking ranking){
        RankingVO rankingVO = new RankingVO();

        rankingVO.setId(ranking.getId());
        rankingVO.setId_user(ranking.getId_user());
        rankingVO.setTeacher_id(ranking.getTeacher_id());
        rankingVO.setGrade(ranking.getGrade());

        return rankingVO;
    }

    public Ranking fromVO(RankingVO rankingVO){
        Ranking ranking = new Ranking();

        ranking.setId(rankingVO.getId());
        ranking.setId_user(rankingVO.getId_user());
        ranking.setTeacher_id(rankingVO.getTeacher_id());
        ranking.setGrade(rankingVO.getGrade());

        return ranking;
    }
}
