package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();

        // Duotas file'as
        Product[] products = {
                new Product("A100","apple","local",Category.PRODUCE),
                new Product("B100","banana","local",Category.PRODUCE),
                new Product("P100","pear","local",Category.PRODUCE),
                new Product("L103","lemon","local",Category.PRODUCE),
                new Product("M201","milk","farm",Category.DAIRY),
                new Product("Y001","yogurt","farm",Category.DAIRY),
                new Product("C333","cheese","farm",Category.DAIRY),
                new Product("R777","rice chex","Nabisco",Category.CEREAL),
                new Product("G111","granola","Nat Valley",Category.CEREAL),
                new Product("BB11","ground beef","butcher",Category.MEAT),
                new Product("CC11","chicken","butcher",Category.MEAT),
                new Product("BC11","bacon","butcher",Category.MEAT),
                new Product("BC77","coke","coca cola",Category.BEVERAGE),
                new Product("BC88","coffee","value",Category.BEVERAGE),
                new Product("BC99","tea","herbal",Category.BEVERAGE)
        };

        // Inventory
        for (Product product : products) {
            store.addInventoryItem(new InventoryItem(product, 4, 3, 2, 1.0));
        }

        // Cart
        Cart cart = new Cart("CAR001", LocalDate.now(), "virtual");
        cart.addItem(products[0], 2);
        cart.addItem(products[1], 7);
        cart.addItem(products[3], 4);
        store.addCart(cart);

        // Manage Cart
        store.manageStoreCarts();

        // Checkout?
        store.checkOutCart("CAR001");

        // List by CAT
        store.listProductsByCategory(Category.CEREAL);
    }
}