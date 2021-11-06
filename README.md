# BookStoreApp
OOP modifactions made:

1. Used a singleton factory to generate the main menu.
  Reason: To remove the operating code from Main (design pattern principle). This could have just been a factory.
  
2. Created UserMenu object to handle the main user menu.
  Reason: Allows inspection of program control flow without code particulars and places job of displaying menu with UserMenu object
  (Single Responsibility Principle (SRP): A class should have one and only one reason to change, meaning that a class should have only one job.) 
  
3. User object now contains methods for userLogin() and registerNewUser().
  Reason: These behaviors belong to the user
  (SRP - although this is not strict. A user would either register or log in (and log out - but couldn't be bothered), so the behavior is
  consistent with a user object, although I thought it silly to have a separate class for each action. However, technically they probably should.)
  
4. Created BookstoreMenu object to handle all book-related actions.
  Reason: these behaviors belong to the bookstore - probably should have called object Bookstore instead.
  (SRP - same as with 3 above. This includes all consistent Bookstore actions as methods, but strictly each method should have it's own class.)
  
5. Changed output of showBooksByCatId() in BookStoreDaoImpl to show book description rather than ISBN.
  Reason: this seemed more consistent with a shopping experience. If a see all books in a category, then it is the description that would lead
  me to see more detail like the price. Also, otherwise description field in database never used.
  
6. Added call to viewCartMenu() after cancelBook() in viewCartMenu().
  Reason: otherwise user is taken back to the bookstore menu and has to press "2" again to view his cart. Made more sense that if book
  deleted from cart you would just see what's in the cart now with the book removed.
  
7. NOTE: You can delete the Book.java and Categories.java objects from the master branch - these are never used
