package com.company;

import java.sql.*;
import java.sql.Connection;

public class BookStoreDaoImpl implements BookStoreDao{
    Connection connection;
    public BookStoreDaoImpl(){this.connection = ConnectionFactory.getConnection(); }

    @Override
    public User getUserLogin(String email, String password) throws SQLException {
        User user = new User();
        String sql = "select * from users where username = '" + email + "' and password = '" + password + "'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        if(resultSet != null){
            int id = resultSet.getInt(1);
            String username = resultSet.getString(2);
            String pass = resultSet.getString(3);
            user = new User(id, username, pass);
        } else
            System.out.println("No user record found \n");
        return user;
    }

    @Override
    public void registerUser(String email, String password) throws SQLException {
        String sql = "insert into users (username, password) values ( ? , ? )";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);

        int count = preparedStatement.executeUpdate();
        if(count > 0)
            System.out.println("New user account created. \n");
        else
            System.out.println("Account was not created. Something went wrong. \n");
    }

    @Override
    public void showCategories() throws SQLException {
        String sql = "Select * from categories";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println("Category ID: " + resultSet.getInt(1) + " Category Name: " + resultSet.getString(2));
        }
    }

    @Override
    public void showBooksByCatId(int catId) throws SQLException {
        String sql = "select * from books where catId = '" + catId +"'";;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println("Book ID: " + resultSet.getInt(1) + " Title: " + resultSet.getString(4) + " Author: " + resultSet.getString(5) + " ISBN: " + resultSet.getString(3));
        }
    }

    @Override
    public void showBookDetails(int bookId) throws SQLException {
    }

    @Override
    public void addShopCart(int bookId, int userId) {

    }

    @Override
    public void viewCart(int userId) {

    }

    @Override
    public void cancelBook(int userId, int bookId) {

    }
}
