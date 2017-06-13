package com.proiect.tw.controller;

import com.proiect.tw.service.ScheduleService;
import com.proiect.tw.vo.ScheduleVO;
import com.proiect.tw.vo.search.ScheduleSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * Created by JACK on 6/12/2017.
 */
@RestController
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    //GET ALL SCHDULES
    @RequestMapping("/schedule")
    public Page<ScheduleVO> getSchedules(Pageable pageable) {

        return scheduleService.getSchedules(pageable);
    }

    //GET ALL SCHDULES BY DAY, GROUP OR CLASS ROOM
    @RequestMapping(value = "/schedule/search")
    public Page<ScheduleVO> searchSchedules(@ModelAttribute ScheduleSearchVO searchVO, Pageable page) {

        return scheduleService.getSchedules(searchVO, page);
    }

    //GET SCHEDULE BY ID
    @RequestMapping("/schedule/{id}")
    public ScheduleVO getSchedule(@PathVariable("id") Integer id) {

        return scheduleService.getSchedule(id);
    }

    //CREATE A NEW SCHEDULE
    @RequestMapping(value = "/schedule", method = RequestMethod.POST)
    public void createSchedule(@RequestBody ScheduleVO scheduleVO) {

        scheduleService.createSchedule(scheduleVO);
    }

    //UPDATE AN EXISTING SCHEDULE
    @RequestMapping(value = "/schedule/{id}", method = RequestMethod.PUT)
    public void updateSchedule(@PathVariable("id") Integer id, @RequestBody ScheduleVO scheduleVO) {

        scheduleService.updateSchedule(id, scheduleVO);
    }

    //DELETE A SCHEDULE
    @RequestMapping(value = "/schedule/{id}", method = RequestMethod.DELETE)
    public void deleteSchedule(@PathVariable("id") Integer id) {

        scheduleService.deleteSchedule(id);
    }
}
