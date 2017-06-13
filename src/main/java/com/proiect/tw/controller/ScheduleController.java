package com.proiect.tw.controller;

import com.proiect.tw.service.ScheduleService;
import com.proiect.tw.vo.ScheduleVO;
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

    @RequestMapping("/schedule")
    public Page<ScheduleVO> getSchedules(Pageable pageable) {

        return scheduleService.getSchedules(pageable);
    }

    @RequestMapping("/schedule/{id}")
    public ScheduleVO getSchedule(@PathVariable("id") Integer id) {

        return scheduleService.getSchedule(id);
    }

    @RequestMapping(value = "/schedule", method = RequestMethod.POST)
    public void createSchedule(@RequestBody ScheduleVO scheduleVO) {

        scheduleService.createSchedule(scheduleVO);
    }

    @RequestMapping(value = "/schedule/{id}", method = RequestMethod.PUT)
    public void updateSchedule(@PathVariable("id") Integer id, @RequestBody ScheduleVO scheduleVO) {

        scheduleService.updateSchedule(id, scheduleVO);
    }

    @RequestMapping(value = "/schedule/{id}", method = RequestMethod.DELETE)
    public void deleteSchedule(@PathVariable("id") Integer id) {

        scheduleService.deleteSchedule(id);
    }
}
