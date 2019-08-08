package com.codecool.shop.dao.dbimplementation;

import com.codecool.shop.dao.Dbconnection;
import com.codecool.shop.dao.UserDao;
import com.codecool.shop.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoDb implements UserDao {
    private static UserDaoDb instance = null;

    /* A private Constructor prevents any other class from instantiating.
     */
    public UserDaoDb() {
    }

    public static UserDaoDb getInstance() {
        if (instance == null) {
            instance = new UserDaoDb();
        }
        return instance;
    }

    Dbconnection dbconnection = new Dbconnection();


    @Override
    public void add(User user) {
        Connection connection = null;

        String username = user.getUsername();
        String hashed_pw = user.getHashedPassword();
        String email = user.getEmail();

        final String addStatement = "INSERT INTO users (username, hashed_pw, email)" +
                "VALUES(?, ?, ?)";

        try {
            connection = dbconnection.connect();

            PreparedStatement preparedAddStatement = connection.prepareStatement(addStatement);
            //preparedAddStatement.setInt(1, 4);
            preparedAddStatement.setString(1, username);
            preparedAddStatement.setString(2, hashed_pw);
            preparedAddStatement.setString(3, email);

            preparedAddStatement.executeUpdate();

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                System.out.println("Could not close connection");
            }
        }
    }
}
