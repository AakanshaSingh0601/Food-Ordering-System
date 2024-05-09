package shopping.model;

import shopping.model.exception.DuplicateProductIDException;
import shopping.model.exception.ProductNotFoundException;

import java.util.Scanner;

public class Catalog {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select operation:");
            System.out.println("1. Add product");
            System.out.println("2. Delete product");
            System.out.println("3. Display cart");
            System.out.println("4. Calculate total price");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    try {
                        if (!cart.productExists(id)) {
                            System.out.print("Enter product name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter product price: ");
                            double price = scanner.nextDouble();
                            System.out.print("Enter product quantity: ");
                            int quantity = scanner.nextInt();
                            scanner.nextLine(); // Consume newline character

                            System.out.print("Enter product type (Electronics/Clothing): ");
                            String type = scanner.nextLine();

                            if (type.equalsIgnoreCase("Electronics")) {
                                System.out.print("Enter brand: ");
                                String brand = scanner.nextLine();
                                System.out.print("Enter warranty period: ");
                                int warrantyPeriod = scanner.nextInt();
                                scanner.nextLine(); // Consume newline character
                                Product product = new Electronics(name, id, price, quantity, brand, warrantyPeriod);
                                cart.addToCart(product);
                            } else if (type.equalsIgnoreCase("Clothing")) {
                                System.out.print("Enter size: ");
                                String size = scanner.nextLine();
                                System.out.print("Enter material: ");
                                String material = scanner.nextLine();
                                Product product = new Clothing(name, id, price, quantity, size, material);
                                cart.addToCart(product);
                            } else {
                                System.out.println("Invalid product type. Please enter either Electronics or Clothing.");
                            }
                        } else {
                            throw new DuplicateProductIDException("Product with ID " + id + " already exists in the cart.");
                        }
                    } catch (DuplicateProductIDException | IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Enter product ID to delete: ");
                        int deleteId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character
                        cart.deleteProduct(deleteId);
                        System.out.println("Product with ID " + deleteId + " deleted successfully.");
                    } catch (ProductNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Cart Contents:");
                    cart.displayCart();
                    break;

                case 4:
                    System.out.println("Total Price: " + cart.calculateTotalPrice() + " Rupees");
                    break;

                case 5:
                    System.out.println("Thankyou, Have a Wonderful Day");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
