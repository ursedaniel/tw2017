package com.proiect.tw.controller;

import com.proiect.tw.service.UserService;
import com.proiect.tw.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by JACK on 6/13/2017.
 */
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void createUser(@RequestBody UserVO userVO) {

        userService.createUser(userVO);
    }
}
