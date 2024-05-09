package shopping.model;

public class Clothing extends Product {
    private String size;
    private String material;

    public Clothing(String productName, int productId, double price, int quantityInStock, String size, String material) {
        super(productName, productId, price, quantityInStock);

        try{
            if(size == null || size.isBlank()) {
                throw new RuntimeException("Please enter a valid Product Name it should not be null or blank");
            }
            this.size = size;

            if(material == null || material.isBlank()) {
                throw new RuntimeException("Please enter Material it should not be null or blank");
            }
            this.material = material;

        }catch(RuntimeException e){
            System.out.println("Please enter valid inputs: " + e.getMessage());
        }
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Size: " + size);
        System.out.println("Material: " + material);
    }
}
