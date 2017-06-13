package com.proiect.tw.service;

import com.proiect.tw.vo.ScheduleVO;
import com.proiect.tw.vo.search.ScheduleSearchVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by JACK on 6/12/2017.
 */
public interface ScheduleService {

    Page<ScheduleVO> getSchedules(Pageable pageable);
    Page<ScheduleVO> getSchedules(ScheduleSearchVO searchVO, Pageable pageable);
    ScheduleVO getSchedule(Integer id);

    void createSchedule(ScheduleVO scheduleVO);
    void updateSchedule(Integer id, ScheduleVO scheduleVO);
    void deleteSchedule(Integer id);
}
