package com.proiect.tw.vo.convertor;

import com.proiect.tw.model.User;
import com.proiect.tw.vo.UserVO;
import org.springframework.stereotype.Service;

/**
 * Created by JACK on 6/13/2017.
 */
@Service
public class UserConvertor {

    public UserVO toVO(User user){
        UserVO userVO = new UserVO();

        userVO.setId(user.getId());
        userVO.setName(user.getName());
        userVO.setEmail(user.getEmail());
        userVO.setRole(user.getRole());

        return userVO;
    }

    public User fromVO(UserVO userVO){
        User user = new User();

        user.setId(userVO.getId());
        user.setName(userVO.getName());
        user.setEmail(userVO.getEmail());
        user.setRole(userVO.getRole());

        return user;
    }
}
