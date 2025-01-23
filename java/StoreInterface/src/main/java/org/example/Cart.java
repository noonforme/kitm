package org.example;

import java.time.LocalDate;
import java.util.*;

public class Cart {
    private final String id;
    private final Map<Product, Integer> products;
    private final LocalDate date;
    private final String type;

    public Cart(String id, LocalDate date, String type) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.products = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void addItem(Product product, int qty) {
        products.put(product, products.getOrDefault(product, 0) + qty);
    }

    public void removeItem(Product product, int qty) {
        if (products.containsKey(product)) {
            int currentQty = products.get(product);
            if (qty >= currentQty) {
                products.remove(product);
            } else {
                products.put(product, currentQty - qty);
            }
        }
    }

    public void printSalesSlip() {
        System.out.println("Cart ID: " + id);
        System.out.println("Date: " + date);
        System.out.println("Cart type: " + type);
        System.out.println("Products: ");
        double total = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            int qty = entry.getValue();
            double itemTotal = qty * 69; // Tik laikinai, kol kainos atsiras :P
            total += itemTotal;
            System.out.println(product + ": " + qty + " x " + itemTotal);
        }
        System.out.println("Total: " + total);
    }
}
