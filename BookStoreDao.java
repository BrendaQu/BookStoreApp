package com.fhw.ProjectBookstore;

import java.sql.SQLException;

public interface BookStoreDao {

    int getUserLogin(String email, String password) throws SQLException;
    void registerUser(String email, String password) throws SQLException;
    void showCategories() throws SQLException;
    void showBooksByCatId() throws SQLException;

    // I take
    void showBookDetails(int bookId) throws SQLException;
    void addShopCart(int bookId, int userId) throws SQLException;
    void viewCart(int userId) throws SQLException;
    void cancelBook(int cartId) throws SQLException;


}
