

import java.sql.*;
import java.sql.Connection;

public class BookStoreDaoImpl implements BookStoreDao{
    Connection connection;
    public BookStoreDaoImpl(){this.connection = ConnectionFactory.getConnection(); }

    @Override
    public User getUserLogin(String email, String password) throws SQLException {
        User user = new User();
        String sql = "select * from Users where username = '" + email + "' and password = '" + password + "'";
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
        String sql = "insert into Users (username, password) values ( ? , ? )";
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
        String sql = "Select * from Categories";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println("Category ID: " + resultSet.getInt(1) + ", Category Name: " + resultSet.getString(2));
        }
    }

    @Override
    public void showBooksByCatId(int catId) throws SQLException {
        String sql = "select * from Books where catId = '" + catId +"'";;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println("Book ID: " + resultSet.getInt(1) + ", Title: " + resultSet.getString(4) + ", Author: " + resultSet.getString(5) + ", Description: " + resultSet.getString(7));
        }
    }


    // I take
    @Override
    public void showBookDetails(int bookId) throws SQLException {
        String sql = "SELECT bookId, ISBN, title, author, price FROM Books WHERE bookId=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, bookId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.format("%-11s%-18s%-50s%-20s%-11s\n", "BOOK ID", "ISBN", "TITLE", "AUTHOR", "PRICE");
            System.out.format("%-11s%-18s%-50s%-20s%-11s\n", resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
                    resultSet.getDouble(5));
        }else{
            System.out.println("Book table could not be accessed");
        }
    }

    @Override
    public void addShopCart(int bookId, int userId) throws SQLException {
        String sql = "INSERT INTO Shopcart (userId, bookId) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, userId);
        preparedStatement.setInt(2, bookId);
        int count = preparedStatement.executeUpdate();
        if(count > 0)
            System.out.println("Added to cart");
        else
            System.out.println("Cart not updated");

    }


    @Override
    public void viewCart(int userId) throws SQLException {
        String sql = "SELECT cartId, title, author, price FROM Books t1 inner join Shopcart t2 on t2.bookId=t1.bookId and t2.userId=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            System.out.format("%-18s%-70s%-20s%-11s\n", "Cart ID", "TITLE", "AUTHOR", "PRICE");
            System.out.format("%-18s%-70s%-20s%-11s\n", resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4));
            while(resultSet.next()){
                System.out.format("%-18s%-70s%-20s%-11s\n", resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4));
            }
        }else{
            System.out.println("No items found in your shopping cart");
        }

    }

    @Override
    public void cancelBook(int cartId) throws SQLException {
        String sql = "DELETE FROM Shopcart WHERE cartId=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, cartId);
        int count = preparedStatement.executeUpdate();
        if(count > 0)
            System.out.println("Book removed from cart");
        else
            System.out.println("Cart not updated");


    }
}
