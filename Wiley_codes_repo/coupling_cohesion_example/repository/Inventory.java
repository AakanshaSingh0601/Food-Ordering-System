package coupling_cohesion_example.repository;


import java.util.ArrayList;
import java.util.List;
import model.Book;

public class Inventory {
   private List<Book> books;

   public Inventory() {
       this.books = new ArrayList<>();
   }

   public void addBook(Book book) {
       books.add(book);
   }

   public void removeBook(Book book) {
       books.remove(book);
   }

   public void displayInventory() {
       System.out.println("Inventory:");
       for (Book book : books) {
           System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Price: $" + book.getPrice());
       }
   }

   public Book findBookByTitle(String title) {
       for (Book book : books) {
           if (book.getTitle().equals(title)) {
               return book;
           }
       }
       return null;
   }

   public List<Book> findBooksByAuthor(String author) {
       List<Book> result = new ArrayList<>();
       for (Book book : books) {
           if (book.getAuthor().equals(author)) {
               result.add(book);
           }
       }
       return result;
   }

   public List<Book> findBooksByPriceRange(double minPrice, double maxPrice) {
       List<Book> result = new ArrayList<>();
       for (Book book : books) {
           if (book.getPrice() >= minPrice && book.getPrice() <= maxPrice) {
               result.add(book);
           }
       }
       return result;
   }
}

