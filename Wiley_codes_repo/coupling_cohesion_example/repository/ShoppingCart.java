package coupling_cohesion_example.repository;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
   private List<Book> items;

   public ShoppingCart() {
       this.items = new ArrayList<>();
   }

   public double calculateTotalPrice() {
       double totalPrice = 0.0;
       for (Book book : items) {
           totalPrice += book.getPrice();
       }
       return totalPrice;
   }

   public void addItem(Book book) {
       items.add(book);
   }

   public void removeItem(Book book) {
       items.remove(book);
   }

   public void displayItems() {
       System.out.println("Shopping Cart Items:");
       for (Book book : items) {
           System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Price: $" + book.getPrice());
       }
   }
}

