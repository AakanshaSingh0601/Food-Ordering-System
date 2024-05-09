package shopping.model;

public interface OnlineShoppingService {
    void addToCart(Product product);
    void displayCart();
    double calculateTotalPrice();
    void deleteProduct(int id);
}
