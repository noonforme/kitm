package org.example;

import java.util.LinkedList;

public class Order {
    private static int idMaker = 1;
    private int orderId;
    private LinkedList<OrderItem> orderItems;

    public Order() {
        this.orderId = idMaker++;
        this.orderItems = new LinkedList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public void addProduct(Product product, int qty) {
        if (product.getStock() < qty) {
            System.out.println("Out of stock - " + product.getProductName());
        }
        product.reduceStock(qty);
        orderItems.add(new OrderItem(product, qty));
    }

    public double calculateTotal() {
        double total = 0.0;
        for (OrderItem orderItem : orderItems) {
            total += orderItem.getSubtotal();
        }
        return total;
    }

    public void applyDiscount() {
        for (OrderItem item : orderItems) {
            item.getProduct().applyDiscount(30);
        }
    }
}