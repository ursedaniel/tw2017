package com.proiect.tw.service.impl;

import com.proiect.tw.exception.BusinessException;
import com.proiect.tw.repository.UserRepository;
import com.proiect.tw.service.UserService;
import com.proiect.tw.vo.UserVO;
import com.proiect.tw.vo.convertor.UserConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by JACK on 6/13/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConvertor userConvertor;

    @Override
    public void createUser(UserVO userVO) {

        if (userRepository.findById(userVO.getId()) == null) {
            userRepository.save(userConvertor.fromVO(userVO));
        }
    }
}
