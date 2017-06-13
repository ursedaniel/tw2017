package com.proiect.tw.vo.convertor;

import com.proiect.tw.model.Schedule;
import com.proiect.tw.vo.ScheduleVO;
import org.springframework.stereotype.Service;

/**
 * Created by JACK on 6/12/2017.
 */
@Service
public class ScheduleConvertor {

    public ScheduleVO toVO(Schedule schedule){
        ScheduleVO scheduleVO = new ScheduleVO();

        scheduleVO.setId(schedule.getId());
        scheduleVO.setTeacher_id(schedule.getTeacher_id());
        scheduleVO.setCourse_id(schedule.getCourse_id());
        scheduleVO.setDay(schedule.getDay());
        scheduleVO.setGroup(schedule.getGroup());
        scheduleVO.setClass_room(schedule.getClass_room());
        scheduleVO.setStarting_at(schedule.getStarting_at());
        scheduleVO.setEnding_at(schedule.getEnding_at());
        scheduleVO.setType(schedule.getType());

        return scheduleVO;
    }

    public Schedule fromVO(ScheduleVO scheduleVO){
        Schedule schedule = new Schedule();

        schedule.setId(scheduleVO.getId());
        schedule.setTeacher_id(scheduleVO.getTeacher_id());
        schedule.setCourse_id(scheduleVO.getCourse_id());
        schedule.setDay(scheduleVO.getDay());
        schedule.setGroup(scheduleVO.getGroup());
        schedule.setClass_room(scheduleVO.getClass_room());
        schedule.setStarting_at(scheduleVO.getStarting_at());
        schedule.setEnding_at(scheduleVO.getEnding_at());
        schedule.setType(scheduleVO.getType());

        return schedule;
    }
}
