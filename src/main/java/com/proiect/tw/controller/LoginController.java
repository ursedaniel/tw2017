package com.proiect.tw.controller;

import com.proiect.tw.service.UserService;
import com.proiect.tw.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by JACK on 6/13/2017.
 */
@CrossOrigin
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    //POST THE LOGGED IN USER
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void createUser(@RequestBody UserVO userVO) {

        userService.createUser(userVO);
    }
}
