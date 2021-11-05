package com.company;

import java.sql.SQLException;

public interface BookStoreDao {
    //Log in as User - Brenda
    User getUserLogin(String email, String password) throws SQLException;

    //Register User populate database automatically -Brenda
    void registerUser(String email, String password) throws SQLException;

    //Show list of Categories - Brenda
    void showCategories() throws SQLException;

    // Show list of books in category - Brenda
    void showBooksByCatId(int catId) throws SQLException;

    //Book Info
    void showBookDetails(int bookId) throws SQLException;

    void addShopCart(int bookId, int userId) throws SQLException;
    void viewCart(int userId) throws SQLException;
    void cancelBook(int cartId) throws SQLException;


}
