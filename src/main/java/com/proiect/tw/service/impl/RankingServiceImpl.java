package com.proiect.tw.service.impl;

import com.proiect.tw.exception.BusinessException;
import com.proiect.tw.model.Ranking;
import com.proiect.tw.model.Teacher;
import com.proiect.tw.repository.RankingRepository;
import com.proiect.tw.repository.TeacherRepository;
import com.proiect.tw.service.RankingService;
import com.proiect.tw.vo.RankingVO;
import com.proiect.tw.vo.convertor.RankingConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by JACK on 6/13/2017.
 */
@Service
public class RankingServiceImpl implements RankingService {

    @Autowired
    private RankingRepository rankingRepository;

    @Autowired
    private RankingConvertor rankingConvertor;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public void createRanking(RankingVO rankingVO) {

        if(rankingVO.getGrade()<1 || rankingVO.getGrade()>10) {
            throw new BusinessException("Error: Nota trebuie sa fie in intervalul [1,10]");
        }

        if (rankingRepository.findByIdUser(rankingVO.getId_user()) == null ||
                rankingRepository.findByTeacherid(rankingVO.getTeacher_id()) == null) {
            System.out.println(rankingVO);
            rankingRepository.save(rankingConvertor.fromVO(rankingVO));
        }
        else if(rankingRepository.findByIdUser(rankingVO.getId_user()) != null &&
                rankingRepository.findByTeacherid(rankingVO.getTeacher_id()) != null){

            Ranking r = rankingRepository.getIdByUser(rankingVO.getTeacher_id(),rankingVO.getId_user());
            rankingVO.setId(r.getId());
            System.out.println("RADA" + rankingVO);
            rankingRepository.save(rankingConvertor.fromVO(rankingVO));
        }

        Teacher teacher = teacherRepository.findOne(rankingVO.getTeacher_id());
        Integer total_votes = rankingRepository.getTotalRating(teacher.getId());
        Integer sum_votes = rankingRepository.getSumRating(teacher.getId());
        teacher.setRating(sum_votes/total_votes);
        teacherRepository.save(teacher);
    }
}