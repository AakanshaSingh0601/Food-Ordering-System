package shopping.model;

public class Product {
    private String productName;
    private int productId;
    private double price;
    private int quantityInStock;

    public Product(String productName, int productId, double price, int quantityInStock) {
        try {
            if (productName == null || productName.isBlank()) {
                throw new RuntimeException("Please enter a valid Product Name it should not be null or blank");
            }
            this.productName = productName;

            if (productId<= 0) {
                throw new RuntimeException("Product ID should be a positive number");
            }
            this.productId = productId;

            if (price<= 0) {
                throw new RuntimeException("Price should be a positive number");
            }
            this.price = price;

            if (quantityInStock<= 0) {
                throw new RuntimeException("Please Enter valid Quantity");
            }
            this.quantityInStock = quantityInStock;

        } catch (RuntimeException e) {
            System.out.println("Please enter valid inputs: " + e.getMessage());
        }
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void displayDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Product ID: " + productId);
        System.out.println("Price: " + price+"Rupees ");
        System.out.println("Quantity in Stock: " + quantityInStock);
    }
}
