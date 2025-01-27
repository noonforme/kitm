package org.example;

public class OrderItem {
    private Product product;
    private int qty;

    public OrderItem(Product product, int qty) {
        this.product = product;
        this.qty = qty;
    }

    public Product getProduct() {
        return product;
    }

    public int getQty() {
        return qty;
    }

    public double getSubtotal() {
        return product.getPrice() * qty;
    }
}