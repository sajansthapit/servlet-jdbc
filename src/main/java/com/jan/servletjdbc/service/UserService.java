package com.jan.servletjdbc.service;

import com.jan.servletjdbc.config.ConnectionFactory;
import com.jan.servletjdbc.dao.UserDao;
import com.jan.servletjdbc.domain.User;
import com.jan.servletjdbc.dto.ResponseDto;

import java.sql.SQLException;

public class UserService {

    private UserDao userDao;

    public UserService(ConnectionFactory connectionFactory) throws SQLException {
        this.userDao = new UserDao(connectionFactory.getPoolConnection());
    }

    public ResponseDto saveUser(User user) throws Exception{
//        userDao = new UserDao(connectionFactory.getPoolConnection());
        boolean result = userDao.saveUser(user);
        if(result){
            return new ResponseDto(true, "User saved successfully");
        }else {
            return new ResponseDto(false,"Fail to save user");
        }
    }
}
