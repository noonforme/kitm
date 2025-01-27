package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StoreManager storeManager = new StoreManager();

        Product laptop = new Electronics("Laptop", 1000, "Electronics", 10);
        Product display = new Electronics("Display", 380, "Electronics", 25);
        Product powerbank = new Electronics("Powerbank", 40, "Electronics", 38);

        Product shirt = new Clothing("Shirt", 50, "Clothing", 43);
        Product pants = new Clothing("Pants", 30, "Clothing", 40);
        Product hat = new Clothing("Hat", 10, "Clothing", 32);

        storeManager.addProduct(laptop);
        storeManager.addProduct(display);
        storeManager.addProduct(powerbank);

        storeManager.addProduct(shirt);
        storeManager.addProduct(pants);
        storeManager.addProduct(hat);


        Customer customer1 = new Customer("John Doe", "john.doe@example.com");
        storeManager.addCustomer(customer1);
        Customer customer2 = new Customer("Hoe Moe", "hoe.moe@example.com");
        storeManager.addCustomer(customer2);


        // Customer 1 ORDERS
        Order order1 = new Order();
        order1.addProduct(laptop, 1);
        order1.addProduct(shirt, 2);
        order1.addProduct(pants, 2);
        customer1.placeOrder(order1);

        Order order2 = new Order();
        order2.addProduct(display, 1);
        order2.addProduct(powerbank, 5);
        order2.addProduct(hat, 10);
        customer1.placeOrder(order2);

        // Customer 2 ORDERS
        Order order3 = new Order();
        order3.addProduct(laptop, 4);
        order3.addProduct(shirt, 1);
        order3.addProduct(pants, 3);
        customer2.placeOrder(order3);

        Order order4 = new Order();
        order4.addProduct(display, 5);
        order4.addProduct(powerbank, 8);
        order4.addProduct(hat, 3);
        customer2.placeOrder(order4);

        System.out.println("-------------------------------");

        customer1.getOrderStatistics();
        customer2.getOrderStatistics();

        System.out.println("-------------------------------");

        storeManager.generateReport();
        storeManager.removeOutOfStock();

        System.out.println("-------------------------------");

        // Filter

        System.out.println("\nFiltered Products (Category: Electronics):");
        List<Product> electronics = ProductFilters.filterByCategory(storeManager.getProducts(), "Electronics");
        for (Product product : electronics) {
            System.out.printf("Product: %s | Price: %.2f | Stock: %d\n",
                    product.getProductName(), product.getPrice(), product.getStock());
        }

        System.out.println("-------------------------------");

        System.out.println("\nFiltered Products (Price Range: $100 - $1000):");
        List<Product> priceFiltered = ProductFilters.filterByPriceRange(storeManager.getProducts(), 100, 1000);
        for (Product product : priceFiltered) {
            System.out.printf("Product: %s | Price: %.2f | Stock: %d\n",
                    product.getProductName(), product.getPrice(), product.getStock());
        }

        System.out.println("-------------------------------");
    }
}
