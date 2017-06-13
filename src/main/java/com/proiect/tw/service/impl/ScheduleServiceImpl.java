package com.proiect.tw.service.impl;

import com.proiect.tw.exception.BusinessException;
import com.proiect.tw.model.Schedule;
import com.proiect.tw.repository.ScheduleRepository;
import com.proiect.tw.repository.specification.ScheduleSpecification;
import com.proiect.tw.service.ScheduleService;
import com.proiect.tw.vo.ScheduleVO;
import com.proiect.tw.vo.convertor.ScheduleConvertor;
import com.proiect.tw.vo.search.ScheduleSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by JACK on 6/12/2017.
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ScheduleConvertor scheduleConvertor;

    private Page<ScheduleVO> convertToVO(Page<Schedule> page) {

        return page.map(scheduleConvertor::toVO);
    }

    @Override
    public Page<ScheduleVO> getSchedules(Pageable pageable) {

        return convertToVO(scheduleRepository.findAll(pageable));
    }

    @Override
    public Page<ScheduleVO> getSchedules(ScheduleSearchVO searchVO, Pageable pageable) {

        return convertToVO(scheduleRepository.findAll(ScheduleSpecification.searchByVO(searchVO), pageable));
    }

    @Override
    public ScheduleVO getSchedule(Integer id) {

        Schedule schedule = scheduleRepository.findOne(id);

        if (schedule == null) {
            throw new BusinessException( "Ora cu id-ul " + id + " nu exista in baza de date! ");
        }

        return scheduleConvertor.toVO(schedule);
    }

    @Override
    public void createSchedule(ScheduleVO scheduleVO) {

        scheduleRepository.save(scheduleConvertor.fromVO(scheduleVO));
    }

    @Override
    public void updateSchedule(Integer id, ScheduleVO scheduleVO) {

        if (scheduleRepository.findOne(id) == null) {
            throw new BusinessException(" Ora cu id-ul " + id + " nu exista in baza de date! ");
        }
        else {
            scheduleRepository.save(scheduleConvertor.fromVO(scheduleVO));
        }
    }

    @Override
    public void deleteSchedule(Integer id) {

        scheduleRepository.delete(id);
    }
}
