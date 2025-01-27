package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StoreManager {
    private ArrayList<Product> products;
    private LinkedList<Customer> customers;

    public StoreManager() {
        products = new ArrayList<>();
        customers = new LinkedList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void generateReport() {
        System.out.println("Store report:");
        for (Product product : products) {
            System.out.printf("Product: %s | Category: %s | Price: %.2f | Stock: %d\n", product.getProductName(), product.getCategory(), product.getPrice(), product.getStock());
        }
    }

    public void removeOutOfStock() {
        products.removeIf(product -> product.getStock() == 0);
    }
}