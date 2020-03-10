package com.jan.servletjdbc.dao;

import com.jan.servletjdbc.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Logger;

public class UserDao {

    private static Logger log = Logger.getLogger(UserDao.class.getName());

    private Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    PreparedStatement preparedStatement = null;

    public boolean saveUser(User user) throws SQLException {
        String query = "INSERT INTO user (user_name, password, email, first_name, last_name, created_date, gender) VALUES (?,?,?,?,?,?,?)";
        try {
            log.info("Creating new User with username" + user.getUsername());
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getFirstName());
            preparedStatement.setString(5, user.getLastName());
            preparedStatement.setString(6, String.valueOf(new Date()));
            preparedStatement.setString(7, user.getGender());
            preparedStatement.executeUpdate();
            log.info("User saved successfully");
            return true;
        } catch (Exception e) {
            log.info("error::" + e.getMessage());
            return false;
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

    }
}
