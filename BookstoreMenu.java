

import java.sql.SQLException;
import java.util.Scanner;

public class BookstoreMenu {


    public BookstoreMenu(){

    }

    public static int getMainMenu(){

        Scanner scanner = new Scanner((System.in));

        System.out.println("\nUser Menu: ");
        System.out.println("Press 1: View all book categories");
        System.out.println("Press 2: View Cart");
        System.out.println("Press 3: Logout");
        int main_menu = scanner.nextInt();
        scanner.nextLine();

        return main_menu;

    }

    public static void viewAllBooksMenu(User user) throws SQLException {

        BookStoreDao dao = BookStoreDaoFactory.getBookStoreDao();
        Scanner scanner = new Scanner((System.in));

        dao.showCategories();
        //Book Menu
        System.out.println("\n Press a category ID to view books in that genre: ");
        int cat_ID = scanner.nextInt();
        dao.showBooksByCatId(cat_ID);
        System.out.println("Press a book ID to view books details: ");
        int book_ID = scanner.nextInt();
        scanner.nextLine();
        dao.showBookDetails(book_ID);
        System.out.println("Press 1 to buy, Press 2 to cancel");
        int buyOp = scanner.nextInt();
        scanner.nextLine();
        if(buyOp == 1){
            dao.addShopCart(book_ID,user.getUserId());
        }
        else if (buyOp == 2) {
            System.out.println("Canceled. Not added to cart.");
        }
        else {
            System.out.println("You entered invalid option");
        }
    }

    public static void viewCartMenu(User user) throws SQLException {

        BookStoreDao dao = BookStoreDaoFactory.getBookStoreDao();
        Scanner scanner = new Scanner((System.in));

        System.out.println("Shopping Cart: ");
        dao.viewCart(user.getUserId());
        System.out.println("Enter 0 to purchase all, or enter Cart ID to cancel an item: ");
        int purOp = scanner.nextInt();
        if (purOp != 0 ) {
            dao.cancelBook(purOp);
            BookstoreMenu.viewCartMenu(user);
        }
        else
            System.out.println("Your order is placed. Thank you.");


    }

}
