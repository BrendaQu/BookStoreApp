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

    //Add Book to shopping cart
    void addShopCart(int bookId, int userId);

    //View cart
    void viewCart(int userId);

    //Cancel Book in cart, delete in table
    void cancelBook(int userId, int bookId);





}
