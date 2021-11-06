

import java.sql.SQLException;
import java.util.Scanner;

public class UserMenu {

    private static UserMenu instance = null;

    private UserMenu() throws SQLException {

        BookStoreDao dao = BookStoreDaoFactory.getBookStoreDao();
        Scanner scanner = new Scanner(System.in);
        boolean login_menu = true;
        while (login_menu) {
            //Login Menu
            System.out.println("Welcome to our bookstore!");
            System.out.println("Press 1: User Login");
            System.out.println("Press 2: Register Account");
            System.out.println("Press 3: Exit Bookstore \n");

            int loginType = scanner.nextInt();
            scanner.nextLine();
            switch (loginType) {
                case 1:

                    boolean user_portal = true;

                    //User login
                    User user = User.userLogin();

                    while (user_portal) {

                        //User Main Menu
                        int main_menu = BookstoreMenu.getMainMenu();

                        switch (main_menu) {
                            case 1:

                                BookstoreMenu.viewAllBooksMenu(user);
                                break;

                            case 2:

                                BookstoreMenu.viewCartMenu(user);
                                break;

                            case 3:

                                user_portal = false;
                                System.out.println("Logging out");
                                System.exit(0);
                                break;

                            default:
                                System.out.println("Select 1-3.");
                        }
                    }
                    break;
                case 2:

                    User.registerNewUser();
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

    public static UserMenu getInstance() throws SQLException{
        if(instance == null)
            instance = new UserMenu();
        return  instance;
    }

}
