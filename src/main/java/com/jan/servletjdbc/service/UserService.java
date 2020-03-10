package com.jan.servletjdbc.service;

import com.jan.servletjdbc.dao.UserDao;
import com.jan.servletjdbc.domain.User;
import com.jan.servletjdbc.dto.ResponseDto;

public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    public ResponseDto saveUser(User user) throws Exception{
        boolean result = userDao.saveUser(user);
        if(result){
            return new ResponseDto(true, "User saved successfully");
        }else {
            return new ResponseDto(false,"Fail to save user");
        }
    }
}
