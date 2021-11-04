package com.company;

public interface BookStoreDao {
    //Log in as User
    User getUserLogin(String email, String password);

    //Register User
    void registerUser(String email, String password);

    //


}
