package org.example;

import java.util.LinkedList;

public class Customer {
    private String name;
    private String email;
    private LinkedList<Order> orderHistory;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.orderHistory = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void placeOrder(Order order) {
        orderHistory.add(order);
    }

    public void getOrderStatistics() {
        System.out.println("Total Orders: " + orderHistory.size());
        double totalSpent = orderHistory.stream().mapToDouble(Order::calculateTotal).sum();
        System.out.println("Total Spent: " + totalSpent);
    }
}