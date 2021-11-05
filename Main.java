package com.company;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
	// write your code here
        BookStoreDao dao = BookStoreDaoFactory.getBookStoreDao();
        Scanner scanner = new Scanner(System.in);
        boolean login_menu = true;
        while(login_menu) {
            //Login Menu
            System.out.println("Welcome to our bookstore!");
            System.out.println("Press 1: User Login");
            System.out.println("Press 2: Register Account");
            System.out.println("Press 2: Exit bookstore \n");

            int loginType = scanner.nextInt();
            scanner.nextLine();
            switch (loginType) {
                case 1:
                    boolean user_portal = true;
                    System.out.println("Please enter your login information: ");
                    System.out.println("Username: ");
                    String username = scanner.nextLine();
                    System.out.println("Password: ");
                    String password = scanner.nextLine();
                    User user = dao.getUserLogin(username, password);
                    System.out.println("Welcome " + user.getUsername() + "! \n");
                    while(user_portal) {
                        //User Main Menu
                        System.out.println("\n User Menu: ");
                        System.out.println("Press 1: View all book categories");
                        System.out.println("Press 2: View Cart");
                        System.out.println("Press 3: Logout");
                        int main_menu = scanner.nextInt();
                        scanner.nextLine();
                        switch (main_menu) {
                            case 1:
                                dao.showCategories();
                                //Book Menu
                                System.out.println("\n Press a category ID to view books in that genre: ");
                                int cat_ID = scanner.nextInt();
                                dao.showBooksByCatId(cat_ID);
                                System.out.println("Press a book ID to view books details: ");
                                int book_ID = scanner.nextInt();
                                scanner.nextLine();
                                dao.showBookDetails(book_ID);
                                break;
                            case 2:
                                break;
                            case 3:
                                user_portal = false;
                                System.out.println("Logging out");
                            default:
                                System.out.println("Select 1-3.");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Register Below: ");
                    System.out.println("Username: ");
                    String n_username = scanner.nextLine();
                    System.out.println("Password: ");
                    String n_password = scanner.nextLine();
                    dao.registerUser(n_username, n_password);
                    break;
                case 3:
                    login_menu = false;
                    System.out.println("Good bye!");
                    break;
                default:
                    System.out.println("Please select 1 or 2.");
            }
        }

    }
}
