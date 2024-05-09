package shopping.model;

import shopping.model.exception.DuplicateProductIDException;
import shopping.model.exception.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements OnlineShoppingService {
    private List<Product> cart;

    public ShoppingCart() {
        this.cart = new ArrayList<>();
    }

    @Override
    public void addToCart(Product product) throws DuplicateProductIDException {
        for(Product p : cart){
            if(p.getProductId() == product.getProductId()){
                throw new DuplicateProductIDException("Item with the ID =  "+product.getProductId()+" is already exist \n These are the details : \n"+product.getProductId()+"\n"+product.getProductName());
            }
        }
        cart.add(product);
    }

    public boolean productExists(int id) {
        for (Product p : cart) {
            if (p.getProductId() == id) {
                return true;
            }
        }
        return false;
    }
    public void deleteProduct(int id) throws ProductNotFoundException {
        boolean found = false;
        for (Product p : cart) {
            if (p.getProductId() == id) {
                cart.remove(p);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new ProductNotFoundException("Product with ID " + id + " is not available in the cart.");
        }
    }

    @Override
    public void displayCart() {
        for (Product product : cart) {
            product.displayDetails();
            System.out.println();
        }
    }

    @Override
    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product product : cart) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
