package coupling_cohesion_example.root;

//import model.Book;
//import repository.Inventory;
//import repository.ShoppingCart;

public class Bookstore {
   public static void main(String[] args) {

       Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 12.99);
       Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 10.50);

       Inventory inventory = new Inventory();
       ShoppingCart cart = new ShoppingCart();

       // Add books to inventory
       inventory.addBook(book1);
       inventory.addBook(book2);

       // Add books to shopping cart
       cart.addItem(book1);
       cart.addItem(book2);

       // Display inventory
       inventory.displayInventory();

       // Display total price of items in shopping cart
       System.out.println("Total price of items in shopping cart: $" + cart.calculateTotalPrice());
   }
}
