package org.example;

public abstract class Product implements Discountable {
    private String productName;
    private double price;
    private String category;
    private int stock;

    public Product(String productName, double price, String category, int stock) {
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.stock = stock;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public int getStock() {
        return stock;
    }

    public void reduceStock(int quantity) {
        if (quantity > stock) {
            System.out.println("Stock too lean - " + productName);
        }
        stock -= quantity;
    }

    @Override
    public void applyDiscount(double discount) {
        price = price - (price * discount);
    }

    @Override
    public void applyBulkDiscount(int quantity, double discount) {
        if (quantity <= stock) {
            price = price - (price * discount);
        }
    }
}