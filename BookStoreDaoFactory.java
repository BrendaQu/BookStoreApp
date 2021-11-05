package com.fhw.ProjectBookstore;

public class BookStoreDaoFactory {

    private static BookStoreDao dao;

    private BookStoreDaoFactory() {

    }
    public static BookStoreDao getBookStoreDao() {
        if(dao == null){
            dao = new BookStoreDaoImpl();
        }
        return dao;
    }

}
