

import java.sql.SQLException;
import java.util.Scanner;

public class User {
    protected int userId;
    protected String username;
    protected String password;

    public User() {
    }

    public User( int userId, String username, String password){
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId( int userId){
        this.userId = userId;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public static User userLogin() throws SQLException {
        BookStoreDao dao = BookStoreDaoFactory.getBookStoreDao();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your login information: ");
        System.out.println("Username: ");
        String username = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        User user = dao.getUserLogin(username, password);
        System.out.println("Welcome " + user.getUsername() + "! \n");
        return user;

    }

    public static void registerNewUser() throws SQLException {
        BookStoreDao dao = BookStoreDaoFactory.getBookStoreDao();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Register Below: ");
        System.out.println("Username: ");
        String n_username = scanner.nextLine();
        System.out.println("Password: ");
        String n_password = scanner.nextLine();
        dao.registerUser(n_username, n_password);
    }
}
